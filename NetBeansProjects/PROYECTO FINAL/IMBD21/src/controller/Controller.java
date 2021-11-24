package controller;

import data.Model;

import java.io.File;

public class Controller {
    
    Model m = new Model();


    public String importarArchivo( File f) {
        return m.importarArchivo(f);
    }

    // PELICULAS ------------------------------------------------------------

    public void agregarPelicula(String[] datos) {
        m.agregarPelicula(datos);
    }

    public void modificarPelicula(String pelicula, int id, String nuevo) {
        m.modificarPelicula(pelicula, id, nuevo);
    }

    public boolean verSiExistePelicula(String pelicula) {
        return m.verSiExistePelicula(pelicula);
    }

    public void eliminarPelicula(String pelicula) {
        m.eliminarPelicula(pelicula);
    }

    public String[][] consultarPelicula(String pelicula) {
        return m.consultarPelicula(pelicula);
    }

    // DIRECTORES ------------------------------------------------------------

    public void agregarDirector(String[] datos) {
        m.agregarDirector(datos);
    }

    public void modificarDirector(String director, int id, String nuevo) {
        m.modificarDirector(director, id, nuevo);
    }

    public boolean verSiExisteDirector(String director) {
        return m.verSiExisteDirector(director);
    }

    public void eliminarDirector(String director) {
        m.eliminarDirector(director);
    }

    

}
