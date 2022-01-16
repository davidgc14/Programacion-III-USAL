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

    public void addLibro(String[] datos) {
        m.addLibro(datos);
    }

    public int buscarLibro(String nombre) {
        return m.buscarLibro(nombre);
    }
    public void editLibro(int parametro, int puestoEnLista, String nuevoValor) {
        m.editLibro(parametro, puestoEnLista, nuevoValor);
    }

    public String imprimirLibro(int puestoEnLista) {
        return m.imprimirLibro(puestoEnLista);
    }

    public void deleteLibro(int puestoEnLista) {
        m.deleteLibro(puestoEnLista);
    }

    public String[][] listaCompleta() {
        return m.imprimirLista();
    }




    
}
