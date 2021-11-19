package controller;

import data.Model;

import java.io.File;

public class Controller {
    
    Model m = new Model();
    

    public String leerDatos(File rutaArchivo) {
        return m.leerDatos(rutaArchivo);
    }

    public String[][] mostrarDatos() {
        return m.mostrarDatos();
    }

    public String añadirUsuario(String nombre, String apellido1, String apellido2) {
        return m.añadirUsuario(nombre, apellido1, apellido2);
    }
    
}
