package controller;

import data.Model;

import java.io.File;

public class Controller {
    
    Model m = new Model();


    public String importarArchivo( File f) {
        return m.importarArchivo(f);
    }

}
