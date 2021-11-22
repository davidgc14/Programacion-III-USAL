package data;

import java.util.ArrayList;
import java.util.List;

public class Filmoteca {

    private List<Pelicula> peliculas;
    private List<Director> directores;
    private List<Actor> actores;
    private List<String> rutasArchivos;

    // Constructor
    public Filmoteca() {
        this.peliculas = new ArrayList<>();
        this.directores = new ArrayList<>();
        this.actores = new ArrayList<>();
        this.rutasArchivos = new ArrayList<>();
    }

    public Filmoteca(List<Pelicula> peliculas, List<Director> directores, List<Actor> actores, List<String> rutasArchivos) {
        this.peliculas = peliculas;
        this.directores = directores;
        this.actores = actores;
        this.rutasArchivos = rutasArchivos;
    }



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

    /*
    public void setPath(String path) {
        this.rutasArchivos.add(path);
    }
    */


    // GETTERS

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public String getPath() {
        return rutasArchivos.get(0);
    }


    // METODOS

    public void addPelicula(Pelicula pelicula) {
        this.peliculas.add(pelicula);
    }

    public void addDirector(Director director) {
        this.directores.add(director);
    }

    public void addActor(Actor actor) {
        this.actores.add(actor);
    }

    public void addPath(String path) {
        this.rutasArchivos.add(path);
    }

} // end class Filmoteca
    
    

