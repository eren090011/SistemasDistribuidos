using System;
using System.Collections.Generic;
using System.IO;
using System.Net.Sockets;

public class Client : SocketProcess
{
    private TcpClient tcpClient;
    private Session session;
    private volatile bool disconnectRequested = false;
    private bool authorized = false;

    public Client(TcpClient tcpClient)
    {
        this.tcpClient = tcpClient;
        this.session = null;
    }

    public bool Connect()
    {
        try
        {
            this.session = new Session(this.tcpClient.GetStream());
            return true;
        }
        catch (Exception e)
        {
            Console.WriteLine("Error connecting: " + e.Message);
            return false;
        }
    }

    public bool Identify(string name)
    {
        if (this.session == null)
        {
            Console.WriteLine("Error: No session initialized.");
            return false;
        }

        try
        {
            // Enviar el nombre para la identificación
            if (!this.session.Write(name))
            {
                Console.WriteLine("Error sending identification name.");
                return false;
            }

            // Leer la respuesta del servidor
            var response = this.session.Read() as string;
            if (response == "-/AUTHORIZED")
            {
                this.authorized = true;
                Console.WriteLine("Client authorized.");
                return true;
            }
            else
            {
                Console.WriteLine("Client not authorized: " + response);
                return false;
            }
        }
        catch (Exception e)
        {
            Console.WriteLine("Error during identification: " + e.Message);
            return false;
        }
    }

    public List<object> Read()
    {
        var dataList = new List<object>();
        bool next = true;
        object data = null;
        int flag = 1;

        while (next)
        {
            if (this.session == null || disconnectRequested)
            {
                return null;
            }

            try
            {
                data = this.session.Read();
                if (data != null)
                {
                    try
                    {
                        flag = Convert.ToInt32(data);
                    }
                    catch (Exception)
                    {
                        flag = 1;
                    }
                    if (data is string && "-/DISCONNECT".Equals(data))
                    {
                        Console.WriteLine("Received disconnect message.");
                        disconnectRequested = true;
                        this.Close();
                        break;
                    }
                    next = flag != 0;
                    if (next)
                    {
                        dataList.Add(data);
                    }
                }
                else
                {
                    next = false;
                    this.Close();
                    Console.WriteLine("Session closed unexpectedly.");
                    break;
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Error reading data: " + e.Message);
                break;
            }
        }
        return dataList;
    }

    public bool Write(List<object> data)
    {
        if (!authorized)
        {
            Console.WriteLine("Client not authorized to send messages.");
            return false;
        }

        if (this.session != null)
        {
            foreach (var d in data)
            {
                if (!this.session.Write(d))
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            Console.WriteLine("Session is null, cannot write.");
            return false;
        }
    }

    public bool Close()
    {
        bool successful = false;
        if (this.session != null)
        {
            successful = this.session.Close();
            this.session = null;
        }
        else
        {
            Console.WriteLine("Session already closed or never initialized.");
        }
        return successful;
    }
}
