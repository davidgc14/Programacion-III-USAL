package data;

import java.io.Serializable;

public class Libro implements Serializable{
    
    private String autor;
    private String titulo;
    private String editorial;
    private int isbn;
    private int fecha;

    public Libro(String titulo, String autor, String editorial, int isbn, int fecha) {
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.isbn = isbn;
        this.fecha = fecha;
    }

    public Libro() {
        this.autor = "" ;
        this.titulo = "" ;
        this.editorial = "" ;
        this.isbn = -1 ;
        this.fecha = -1 ;
    }

    static Libro factory(String[] datos) {
        
        if(datos.length != 5) {
            return null;
        }

        Libro lib = new Libro(datos[0],
                            datos[1],
                            datos[2],
                            Integer.parseInt(datos[3]),
                            Integer.parseInt(datos[4]));

        return lib;
    }

    
    // GETTERS Y SETTERS ---------------------------------------------------

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
}

