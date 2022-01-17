package controller;

import java.io.File;

import data.Model;

public class Controller {
    
    Model m = new Model();

    public String importarArchivo(File f) {
        return m.importarArchivo(f);
    }

    // menu peliculas ---------------------------------------------------

    public String[][] listarPeliculas() {
        return m.listarPeliculas();
    }
}

