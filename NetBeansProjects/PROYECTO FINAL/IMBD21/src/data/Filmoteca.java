package data;

import java.util.ArrayList;
import java.util.List;

import data.data_films.Pelicula;
import data.data_films.Director;
import data.data_films.Actor;

public class Filmoteca {

    List<Pelicula> peliculas = new ArrayList<>();
    List<Director> directores = new ArrayList<>();
    List<Actor> actores = new ArrayList<>();
    List<String> rutasArchivos = new ArrayList<>();

    public Filmoteca(List<String> rutasArchivos) {
        this.rutasArchivos = rutasArchivos;
    }

    


} // end class Filmoteca
    
    

