package controller;

import java.io.File;
import static com.coti.tools.OpMat.*;
import static com.coti.tools.Rutas.*;

import data.Model; 


public class Controller {

    Model m = new Model();

    public void importarListaAlumnos() throws Exception {
        File f = fileToFileOnDesktop("lista_asistencia.txt");

        var tmp = importFromDisk(f, "\t"); // tambien se peude poner String[][]  
        m.setTablaGeneral(tmp);
    }

    public String[][] obtenerTablaGeneral() {
        String [][] tmp = m.getTablaGeneral();
        return tmp;
    }

    public String[][] obtenerTablaBajaAsistencia() {
        return m.getTablaPocaAsistencia();
    }

    public void exportarTablaGeneral() throws Exception {
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
