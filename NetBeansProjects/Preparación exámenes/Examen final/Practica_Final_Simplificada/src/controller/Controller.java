package controller;

import java.io.File;

import data.Model;

public class Controller {
    
    Model m = new Model();

    public String importarArchivo(File f) {
        return m.importarArchivo(f);
    }

    // menu peliculas ---------------------------------------------------

    public String addPelicula(String[] datos) {
        return m.addPelicula(datos);
    }

    public String deletePelicula(String nombre) {
        return m.deletePelicula(nombre);
    }

    public String searchPelicula(String nombre) {
        return m.searchPelicula(nombre);
    }

    public String[][] listarPeliculas() {
        return m.listarPeliculas();
    }
}

