package controller;

import java.io.File;

import data.Model;

public class Controller {
    
    Model m = new Model();

    public String importarContactos(File f) {
        return m.importarContactos(f);
    }

    public String[][] listarContactosPorNombre() {
        return m.listarContactosPorNombre();
    }

    public String[][] listarContactosPorApellido() {
        return m.listarContactosPorApellido();
    }

    public void anadirContacto(String nombre, String apellido, int numero) {
        m.anadirContacto(nombre, apellido, numero);
    }


    public String exportarContactos(File f) {
        return m.exportarContactos(f);
    }

    public boolean verSiExiste(String borrar) {
        return m.verSiExiste(borrar);
    }

    
} // class Controller
