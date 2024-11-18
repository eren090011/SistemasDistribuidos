package correo_servidor.Server.Interfaz;

import correo_servidor.Noticia.NoticiaModel;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;



public interface InterfaceServer extends Remote{
    public String Usuario(String Nombre, String Contraseña) throws RemoteException;
    public void logout(String sessionId) throws RemoteException;
    public boolean esAdministrador(String Nombre) throws SQLException, RemoteException;

    public boolean RegistroUsu(String NombreUsuario, String Contraseña, boolean esAdmin) throws RemoteException;
    public boolean EliminarUsu(int usuarioId) throws RemoteException;

    public boolean crearNotica(String sessionId, int id, String Nombre, String Titular, Date Fecha_Crear, Date Actual_Fecha, String Autor, String Contenido) throws RemoteException;
    public NoticiaModel obtenerNoticia(String sessionId, int id) throws RemoteException;
    public boolean actualizarNoticia(String sessionId, int id, String Nombre, String Titular, Date Fecha_Crear, Date Actual_Fecha, String Autor, String Contenido) throws RemoteException;
    public boolean eliminarNoticia(String sessionId ,int id) throws RemoteException;
    public List<NoticiaModel> listarNoticias(String sessionId) throws RemoteException;
    public List<NoticiaModel> buscarNoticias(String sessionId ,String Busqueda) throws RemoteException;
}
