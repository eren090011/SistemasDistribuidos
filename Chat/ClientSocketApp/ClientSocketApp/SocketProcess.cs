using System.Collections.Generic;

public interface SocketProcess
{
    // Crea el socket lo enlaza a un puerto específico y una IP
    bool Connect();
    // Escucha al servidor y devuelve la respuesta mediante un array de objetos
    List<object> Read();
    // Manda una petición al servidor
    bool Write(List<object> data);
    // Cierra la comunicación
    bool Close();
}
