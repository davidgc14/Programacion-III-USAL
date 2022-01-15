package data;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

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


    private String[][] listarContactos() {

        String[][] listado = new String[contactos.size()][3];

        for (int i = 0 ; i<contactos.size() ; i++) {
            listado[i][0] = contactos.get(i).getNombre();
            listado[i][1] = contactos.get(i).getApellido();
            listado[i][2] = String.valueOf(contactos.get(i).getNumero());
        }
        
        return listado;
    }

    public String[][] listarContactosPorNombre() {
        contactos.sort(Comparator.comparing(Contacto::getNombre));
        return listarContactos();
    }

    public String[][] listarContactosPorApellido() {
        contactos.sort(Comparator.comparing(Contacto::getApellido));
        return listarContactos();
    }


    public void anadirContacto(String nombre, String apellido, int numero) {
        contactos.add(new Contacto(nombre, apellido, numero));
    }



    public String exportarContactos(File f) {

        String[][] tmp = listarContactos();

        try {
            exportToDisk(tmp, f, "\t");
        } catch (Exception ex) {
            return "ERROR: no se han podido exportar los datos. Se perderán los datos guardados.";
        }
        return null;
    }


    public boolean verSiExiste(String borrar) {
        boolean existe = false;
        Contacto encontrado = new Contacto("", "", 0);
        for (Contacto c : contactos) {
            if (borrar.equalsIgnoreCase(c.getNombre()+" "+c.getApellido())) {
                existe = true;
                encontrado = c;
            }
        }
        contactos.remove(encontrado);

        return existe;
    }



} // end class Model

