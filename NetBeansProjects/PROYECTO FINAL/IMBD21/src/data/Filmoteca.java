package data;

import java.util.ArrayList;
import java.util.List;

public class Filmoteca {

    List<Pelicula> peliculas = new ArrayList<>();
    List<Director> directores = new ArrayList<>();
    List<Actor> actores = new ArrayList<>();
    List<String> rutasArchivos = new ArrayList<>();


    //public Filmoteca() {
    //}

    // SETTERS          

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public void setRutasArchivos(List<String> rutasArchivos) {
        this.rutasArchivos = rutasArchivos;
    }

} // end class Filmoteca
    
    

