using System;
using System.IO;
using System.Net.Sockets;

public class Session
{
    private NetworkStream networkStream;
    private BinaryWriter writer;
    private BinaryReader reader;

    public Session(NetworkStream networkStream)
    {
        this.networkStream = networkStream;
        this.writer = new BinaryWriter(this.networkStream);
        this.reader = new BinaryReader(this.networkStream);
    }

    public object Read()
    {
        if (this.reader == null)
        {
            Console.WriteLine("Error: Session is null.");
            return null;
        }
        try
        {
            string data = this.reader.ReadString();
            return data;
        }
        catch (IOException e)
        {
            Console.WriteLine("Error reading data: " + e.Message);
            this.Close();
            return null;
        }
    }

    public bool Write(object data)
    {
        if (this.writer == null)
        {
            Console.WriteLine("Error: Session is null.");
            return false;
        }
        try
        {
            if (data is string)
            {
                this.writer.Write((string)data);
            }
            else
            {
                Console.WriteLine("Error: Data type not supported.");
                return false;
            }
            this.writer.Flush();
            return true;
        }
        catch (IOException e)
        {
            Console.WriteLine("Error writing data: " + e.Message);
            this.Close();
            return false;
        }
    }

    public bool Close()
    {
        bool successful = true;
        try
        {
            this.writer?.Close();
        }
        catch (IOException e)
        {
            Console.WriteLine("Error closing writer: " + e.Message);
            successful = false;
        }
        try
        {
            this.reader?.Close();
        }
        catch (IOException e)
        {
            Console.WriteLine("Error closing reader: " + e.Message);
            successful = false;
        }
        return successful;
    }
}



