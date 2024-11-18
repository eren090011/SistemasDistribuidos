using System;
using System.IO;
using System.Net.Sockets;
using System.Runtime.Serialization;
using System.Threading.Tasks;

[DataContract]
class Message
{
    [DataMember]
    public string Content { get; set; }
}

class Program
{
    private static string _serverAddress = "127.0.0.1";
    private static int _port = 1802;

    static async Task Main(string[] args)
    {
        try
        {
            using (var client = new TcpClient(_serverAddress, _port))
            using (var stream = client.GetStream())
            using (var reader = new BinaryReader(stream))
            using (var writer = new BinaryWriter(stream))
            {
                var serializer = new DataContractSerializer(typeof(Message));

                Console.WriteLine("Connected to the server");

                // Solicitar nombre de usuario
                Console.Write("Ingrese su nombre: ");
                string userName = Console.ReadLine();

                // Verificar que el nombre no sea nulo o vacío
                if (string.IsNullOrWhiteSpace(userName))
                {
                    Console.WriteLine("Nombre no puede ser nulo.");
                    return;
                }

                // Enviar nombre de usuario al servidor
                var userNameMessage = new Message { Content = userName };
                SendMessage(writer, serializer, userNameMessage);

                // Leer la respuesta del servidor
                var responseMessage = ReceiveMessage(reader, serializer);
                if (responseMessage != null)
                {
                    Console.WriteLine(responseMessage.Content);
                    if (responseMessage.Content.Contains("Cliente no autorizado."))
                    {
                        Console.WriteLine("Client identification failed or unauthorized.");
                        return;
                    }
                }

                // Escuchar mensajes del servidor
                Task.Run(async () =>
                {
                    while (true)
                    {
                        var serverMessage = ReceiveMessage(reader, serializer);
                        if (serverMessage != null)
                        {
                            Console.WriteLine(serverMessage.Content);
                        }
                        else
                        {
                            // La conexión fue cerrada por el servidor
                            Console.WriteLine("La conexión fue cerrada por el servidor");
                            break;
                        }
                    }
                });

                // Enviar mensajes al servidor
                while (true)
                {
                    string messageContent = Console.ReadLine();
                    if (!string.IsNullOrWhiteSpace(messageContent))
                    {
                        var message = new Message { Content = messageContent };
                        SendMessage(writer, serializer, message);
                    }
                }
            }
        }
        catch (IOException ex)
        {
            Console.WriteLine($"Error reading or writing data: {ex.Message}");
        }
        catch (SocketException ex)
        {
            Console.WriteLine($"Socket error: {ex.Message}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Unexpected error: {ex.Message}");
        }
    }

    private static void SendMessage(BinaryWriter writer, DataContractSerializer serializer, Message message)
    {
        using (var memoryStream = new MemoryStream())
        {
            serializer.WriteObject(memoryStream, message);
            byte[] messageBytes = memoryStream.ToArray();

            // Enviar la longitud del mensaje seguida de los bytes del mensaje
            writer.Write(messageBytes.Length);
            writer.Write(messageBytes);
            writer.Flush();
        }
    }

    private static Message ReceiveMessage(BinaryReader reader, DataContractSerializer serializer)
    {
        try
        {
            // Leer la longitud del mensaje
            int messageLength = reader.ReadInt32();
            byte[] messageBytes = reader.ReadBytes(messageLength);

            using (var memoryStream = new MemoryStream(messageBytes))
            {
                return (Message)serializer.ReadObject(memoryStream);
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error receiving message: {ex.Message}");
            return null;
        }
    }
}
