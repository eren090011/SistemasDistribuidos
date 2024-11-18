package Chat;

import java.rmi.Naming;
import java.util.List;

public class Client {

  private String url;

  public Client(String ip, String port, String serviceName) {
    this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
  }
/*
  public int loginUser(String name,String password){
        try {
          RMIUSERS usrService= (RMIUSERS) Naming.lookup(this.url);
          return usrService.loginUser(name, password);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return 0;
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
    */
  
}
