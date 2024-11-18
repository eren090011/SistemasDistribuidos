

package edu.lenin;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Jesus
 */
public interface RMINEWS extends Remote{
    public List<Object[]> getNews() throws RemoteException;
    
    public Boolean createNews(String Titulo,String Contenido,int idAutor ) throws RemoteException; 
    public Boolean updateNews(int idNoticia,String Titulo,String Contenido) throws RemoteException; 
    
    public Boolean deleteNews(int idNoticia) throws RemoteException; 
    public List<Object[]> getAllNews(String ip, String port) throws RemoteException;
    
    
}
