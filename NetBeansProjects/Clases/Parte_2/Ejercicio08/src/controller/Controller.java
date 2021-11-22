package controller;

import data.Model;

import static com.coti.tools.OpMat.*;
import com.coti.tools.Rutas;
import java.io.File;


public class Controller {
    
    Model m = new Model();

    public void cleanUp() {
        m.cleanUp();
    }

    public String[][] obtenerTablaGeneral() {
        return m.obtenerTablaGeneral();
    }

    public String[][] obtenerTablaBajaAsistencia() {
        return m.obtenerTablaBajaAsistencia();
    }

    public void exportarTablaGeneral() throws Exception {
        String[][] tmp = m.exportarTablaGeneral();
        File f = Rutas.fileToFileInFolderOnDesktop(m.getFolder(), m.getNameFile());
        exportToDisk(tmp, f, "\t");
    }

    public void exportarTablaBajaAsistencia() throws Exception {
        // tambien se puede usar var instead of String[][]
        String[][] tmp = m.exportarTablaBajaAsistencia();
        File f = Rutas.fileToFileInFolderOnDesktop(m.getFolder(), m.getNameAbsenceFile());
        exportToDisk(tmp, f, "\t");
    }

    public void importarListaGeneral() throws Exception {
        File f = Rutas.fileToFileInFolderOnDesktop(m.getFolder(), m.getNameFile());
        String[][] tmp = importFromDisk(f, "\t");
        m.importarListaGeneral(tmp);
    }

    public void ordenarPorApellidosYNombre() {
        m.ordenarPorApellidosYNombre();
    }

    public void ordenarPorDNI() {
        m.ordenarPorDNI();
    }

    public void ordenarPorAsistenciaApellidosYNombre() {
        m.ordenarPorAsistenciaApellidosYNombre();
    }
    
}
