package controller;

import java.io.File;

import data.Model;

public class Controller {
    
    Model m = new Model();

    public String importarContactos(File f) {
        return m.importarContactos(f);
    }

    public String[][] listarContactos() {
        return m.listarContactos();
    }
}
