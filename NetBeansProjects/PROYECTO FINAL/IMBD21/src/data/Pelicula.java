package data;

public class Pelicula {

    private String titulo;
    private String año;
    private String duracion;
    private String pais;
    private String[] direccion;
    private String guionista;
    private String musica;
    private String[] reparto;
    private String productora;
    private String sinopsis;
    private String genero;

    // CONSTRUCTOR
    
    public Pelicula(String titulo, String año, String duracion, String pais, String[] direccion, String guionista, String musica, String[] reparto, String productora, String sinopsis, String genero) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.pais = pais;
        this.direccion = direccion;
        this.guionista = guionista;
        this.musica = musica;
        this.reparto = reparto;
        this.productora = productora;
        this.sinopsis = sinopsis;
        this.genero = genero;
    }

    // FACTORY

    static Pelicula factory(String[] datos) {
        if (datos.length != 11) {
                return null;
            }
        
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] == null) {
                return null;
            }
        }
        
        return new Pelicula(datos[0], 
                            datos[1], 
                            datos[2], 
                            datos[3], 
                            datos[4].split(","), 
                            datos[5], 
                            datos[6], 
                            datos[7].split(","), 
                            datos[8], 
                            datos[9], 
                            datos[10]);
    }

    // CONVERSOR A STRING

    public String[] toStringArray() {
        String[] datos = {titulo, año, duracion, pais, String.join(",", direccion), guionista, musica, String.join(",", reparto), productora, sinopsis, genero};
        return datos;
    }


    // GETTERS & SETTERS  ---------------------------------------------------

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String[] getDireccion() {
        return direccion;
    }

    public void setDireccion(String[] direccion) {
        this.direccion = direccion;
    }

    public String getGuionista() {
        return guionista;
    }

    public void setGuionista(String guionista) {
        this.guionista = guionista;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String[] getReparto() {
        return reparto;
    }

    public void setReparto(String[] reparto) {
        this.reparto = reparto;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

} // end class Pelicula
