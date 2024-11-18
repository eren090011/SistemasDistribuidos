package correo_servidor.Noticia;

import java.sql.*;

public class NoticiaModel {
    private int id;
    private String Nombre;
    private String Titular;
    private Date Fecha_Crear;
    private Date Actual_Fecha;
    private String Autor;
    private String Contenido;

    public NoticiaModel(int id, String Nombre, String Titular, Date Fecha_Crear, Date Actual_Fecha, String Autor, String Contenido) {
        this.id = id;
        this.Nombre = Nombre;
        this.Titular = Titular;
        this.Fecha_Crear = Fecha_Crear;
        this.Actual_Fecha = Actual_Fecha;
        this.Autor = Autor;
        this.Contenido = Contenido;
    }

    public int getid() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTitular() {
        return Titular;
    }

    public Date getFecha_Crear() {
        return Fecha_Crear;
    }

    public Date getActual_Fecha() {
        return Actual_Fecha;
    }

    public String getAutor() {
        return Autor;
    }

    public String getContenido() {
        return Contenido;
    }
}
