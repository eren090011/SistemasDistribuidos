package edu.lenin;

import java.rmi.Naming;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Client {
    

  private String url;

  public Client(String ip, String port, String serviceName) {
    this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
  }

  public String sayHello(String msg) {
    try {
      RMIMSG service = (RMIMSG) Naming.lookup(this.url);
      return service.sayHello(msg);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
    public List<Object[]> getUsuarios(){
      try {
          RMIUSERS usrService= (RMIUSERS) Naming.lookup(this.url);
          return usrService.getUsuarios();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
    }
    public boolean RegisterUser(String name,String password){
        try {
          RMIUSERS usrService= (RMIUSERS) Naming.lookup(this.url);
          return usrService.RegisterUser(name, password);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return false;
    }
    public boolean updateUser(int id,String name,String password){
        try {
          RMIUSERS usrService= (RMIUSERS) Naming.lookup(this.url);
          return usrService.UpdateUser(id,name, password);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return false;
    }
    public boolean deleteUser(int id){
        try {
          RMIUSERS usrService= (RMIUSERS) Naming.lookup(this.url);
          return usrService.DeleteUser(id);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return false;
    }
    public List<Object[]> getNoticias(){
      try {
          RMINEWS nwsService= (RMINEWS) Naming.lookup(this.url);
          return nwsService.getNews();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
    }
  
  public boolean crearNoticia(String titulo, String contenido, int idAutor){
      try {
          RMINEWS nwsService= (RMINEWS) Naming.lookup(this.url);
          return nwsService.createNews(titulo, contenido, idAutor);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return false;
  }
  public boolean actualizarrNoticia(int idNoticia,String titulo, String contenido){
      try {
          RMINEWS nwsService= (RMINEWS) Naming.lookup(this.url);
          return nwsService.updateNews(idNoticia,titulo, contenido);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return false;
  }
  public boolean borrarNoticia(int idNoticia){
      try {
          RMINEWS nwsService= (RMINEWS) Naming.lookup(this.url);
          return nwsService.deleteNews(idNoticia);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return false;
  }
  
  public List<Object[]> getAllNoticias(String ip,String port){
      try {
          RMINEWS nwsService= (RMINEWS) Naming.lookup(this.url);
          return nwsService.getAllNews(ip,port);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;
    }
    
  
}
