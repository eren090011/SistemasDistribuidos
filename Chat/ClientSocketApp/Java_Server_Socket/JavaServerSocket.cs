using System;
using System.Net.Sockets;

public class JavaServerSocket
{
    private int port;
    private string address;

    public JavaServerSocket(int port, string address)
    {
        this.port = port;
        this.address = address;
    }

    public TcpClient Get()
    {
        try
        {
            return new TcpClient(address, port);
        }
        catch (Exception e)
        {
            Console.WriteLine("Error creating socket: " + e.Message);
            return null;
        }
    }
}

