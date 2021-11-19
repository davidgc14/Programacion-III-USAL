package data;

import java.io.File;


import java.util.ArrayList;
import java.util.List;

import static com.coti.tools.OpMat.*;
import com.coti.tools.Rutas;


public class Model {

    private List<Persona> listaPersonas = new ArrayList<Persona>();
    
    public String leerDatos(File f) {

        String[][] tmp;
        
        if(!f.exists()) {
            return "ERROR: El archivo no existe en la ruta";
        } 
        
        try {
            tmp = importFromDisk(f, "\t");
        } catch (Exception ex) {
            return "ERROR: El archivo no es un archivo de texto / no se puede leer el archivo";
        }
        
        // Comprobacion extra para ver si no está vacio
        if(tmp == null) {
            return "ERROR: El archivo está vacío";
        }
        

        for (String[] fila : tmp) {
            if(fila.length != 3) {
                return "ERROR: El archivo no tiene el formato correcto";
            }
            
            this.listaPersonas.add(Persona.factory(fila));
        }

        return "";
    }
    
    public String[][] mostrarDatos() {
        
        String[][] tmp = new String[listaPersonas.size()][3];

        for (int n=0 ; n < listaPersonas.size() ; n++) {
            tmp[n] = listaPersonas.get(n).toStringArray();
        }

        return tmp;
    }

    public String añadirUsuario(String nombre, String apellido1, String apellido2) {
        
        Persona np = new Persona();

        try {
        np.setNombre(nombre);
        np.setPrimerApellido(apellido1);
        np.setSegundoApellido(apellido2);
        
        this.listaPersonas.add(np);

        } catch (Exception ex) {
            return "ERROR: No se ha podido añadir el usuario";
        }

        // sobreescribimos el archivo orgininal con el nuevo usuario
        // primero necesitamos convertir la lista de personas en una matriz
        String[][] tmp = listaToMatrix(this.listaPersonas);
        File file = Rutas.fileToFileOnDesktop("usuarios.txt");

        try {
            exportToDisk(tmp, file, "\t");
        } catch (Exception ex) {
            return "ERROR: No se ha podido guardar el archivo";
        }
        

        return "";
    }

    private String[][] listaToMatrix(List<Persona> lista) {
        String[][] tmp = new String[lista.size()][3];

        for (int n=0 ; n < lista.size() ; n++) {
            tmp[n] = lista.get(n).toStringArray();
        }

        return tmp;
    }

} // class Model
