package controller;

import data.Model;
import java.io.File;

public class Controller {
    
    Model m = new Model();

    public String leerArchivo(File archivo) {
        return m.leerArchivo(archivo);
    }

    public void imprimirDatos() {
        m.imprimirDatos();
    }
}
