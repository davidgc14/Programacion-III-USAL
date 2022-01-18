package controller;

import java.io.File;

import data.Model;

public class Controller {
    
    Model m = new Model();

    public String importarArchivo(File f) {
        return m.importarArchivo(f);
    }

    public String save(File f1, File f2) {
        return m.save(f1, f2);
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

