package controller;

import java.io.File;
import static com.coti.tools.OpMat.*;
import static com.coti.tools.Rutas.*;

import data.Model; 

//REVISADO Y CORRECTO

public class Controller {

    Model m = new Model();

    public void importarListaAlumnos() throws Exception {
        // en princio el nombre del archivo se repite mas adelante, no se si se sobreescribe
        File f = fileToFileOnDesktop("lista_asistencia.txt");

        var tmp = importFromDisk(f, "\t"); // tambien se peude poner String[][]  
        m.setTablaGeneral(tmp);
    }

    public String[][] obtenerTablaGeneral() {
        String [][] tmp = m.tablaGeneral();
        return tmp;
    }

    public String[][] obtenerTablaBajaAsistencia() {
        return m.tablaPocaAsistencia();
    }

    public void exportarTablaGeneral() throws Exception {
        // el nobmre del archivo es el mismo que el original, no se si se sobreescribe
        String [][] tmp = m.getTablaGeneral();
        File f = fileToFileOnDesktop("lista_asistencia.txt");
        exportToDisk(tmp, f, "\t");
    }

    public void exportarTablaBajaAsistencia() throws Exception {
        var tmp = m.getTablaPocaAsistencia();
        File f = fileToFileOnDesktop("baja_asistencia.txt");
        exportToDisk(tmp, f, "\t");
    }

    public void ordenarListaGeneral() {
        m.ordenarListaGeneral();
    }
    
}
