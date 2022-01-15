package data;



public class Libro {
    
    private String autor;
    private String titulo;
    private String editorial;
    private int isbn;
    private int fecha;

    public Libro(String autor, String titulo, String editorial, int isbn, int fecha) {
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

    


}

