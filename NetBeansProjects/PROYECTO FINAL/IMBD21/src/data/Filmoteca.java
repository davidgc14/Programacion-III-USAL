package data;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Filmoteca {

    private List<Pelicula> peliculas;
    private List<Director> directores;
    private List<Actor> actores;
    private final List<Path> rutasArchivos;

    // Constructor
    public Filmoteca() {
        this.peliculas = new ArrayList<>();
        this.directores = new ArrayList<>();
        this.actores = new ArrayList<>();
        this.rutasArchivos = new ArrayList<>();
    }

    public Filmoteca(List<Pelicula> peliculas, List<Director> directores, List<Actor> actores, List<Path> rutasArchivos) {
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
    
    public void setPath(Path path) {
        this.rutasArchivos.add(path);
    }
    


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

    public List<Path> getPath() {
        return rutasArchivos;
    }

    public Pelicula getPeliculaPorTitulo(String titulo) {
        for (Pelicula p : peliculas) {
            if (p.getTitulo().equalsIgnoreCase(titulo)) {
                return p;
            }
        }
        return null;
    }

    public Director getDirectorPorNombre(String nombre) {
        for (Director d : directores) {
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                return d;
            }
        }
        return null;
    }

    public Actor getActorPorNombre(String nombre) {
        for (Actor a : actores) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }

    public Path getPathPorNombre(String nombre) {
        for (Path p : rutasArchivos) {
            if (p.getFileName().toString().startsWith(nombre)) {
                return p;
            }
        }
        return null;
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

    public void addPath(Path path) {
        this.rutasArchivos.add(path);
    }

} // end class Filmoteca
    
    

