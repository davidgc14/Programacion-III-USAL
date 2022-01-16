package controller;

import java.io.File;

import data.Model;

public class Controller {
    
    Model m = new Model();

    public String importarDatos(File f) {
        return m.importarDatos(f);
    }

    public String salirYguardar() {
        return m.salirYguardar();
    }


    
}
