package controller;


import data.Model;

import java.io.File;
import java.io.FileNotFoundException;


public class Controller {
    
    
    Model m = new Model();
    
    public String importarDatosDe(File rutaDelArchivo) {
        return m.importarDatosDe(rutaDelArchivo);
    }
    
    public int getNumeroTotalDeFacturas() {
        return m.getNumeroTotalDeFacturas();
    }
    
    public void guardarImporteMinimoEnModelo(float tmp) {
        m.setImporteMinimo(tmp);
    }
    
    public float getImporteMinimo() {
        return m.getImporteMinimo();
    }
    
    public void calcularLista() {
        m.getImporteMinimo();
    }
    
    public String[][] getTablaDeFacturas() {
        return m.getTablaDeFacturas();
    }
    
    public void generarArchivoHTML() throws FileNotFoundException {
        m.HTMLdeFacturas();
    }
    
    public String getNombreArchivoHTML() {
        return m.getNombreDelArchivoHTML();
    }
    
    public int getNumeroDeFacturasSolicitadas() {
        return m.getTablaDeFacturas().length;
    }
} // end of class controller
