package data;

import java.io.File;
import java.util.ArrayList;
import static com.coti.tools.OpMat.*;


public class Model {

    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    

    public String importarContactos(File f) {
        String[][] lineas;
        try {
            lineas = importFromDisk(f, "\t");
        } catch (Exception ex) {
            return "ERROR: Archivo en formato erroneo";
        }

        for (String[] linea : lineas) {
            if (linea.length != 3) {
                return "ERROR: archivo con estructura no esperada";
            } else {
                contactos.add(Contacto.factory(linea));
            }
        }

        return null;
    }









    public String[][] listarContactos() {
        String[][] listado = new String[contactos.size()][3];

        return listado;
    }
}
