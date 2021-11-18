package controller;

import data.Model;

import java.io.File;


public class Controller {
    
    Model m = new Model();

    public void importarFacturasDe(File rutaDelArchivo) throws Exception {
        m.importarFacturasDe(rutaDelArchivo);
    }

    public String[][] getTablaDeFacturas() {

        return m.getTablaDeFacturas();
    }
}

