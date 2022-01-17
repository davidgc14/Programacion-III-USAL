package data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static com.coti.tools.OpMat.*;

public class Model {
    
    private ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    private ArrayList<Actor> actores = new ArrayList<Actor>();

    public String importarArchivo(File f) {

        String mensaje = "";

        if (f.getName().endsWith(".bin")) {
    
            mensaje.concat(this.importarPrioridadBinario(f));

        } else {
            // System.out.println("Importando fichero de texto...");
            mensaje.concat(importarTXT(f));
        }

        return mensaje;
    }

    private String importarPrioridadBinario(File f) {
        
        String mensaje = "";

        try{
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            if (f.getName().equals("peliculas")) {
                peliculas = (ArrayList<Pelicula>) ois.readObject();
            } else {
                actores = (ArrayList<Actor>) ois.readObject();                   
            }
            ois.close();

        } catch (Exception ex) {
            mensaje.concat("Error en la importacion de " + f.getName() + "%n");
            mensaje.concat("Se intentará importar archivo por defecto%n");
        }

        if (!mensaje.isEmpty()) {

        }

        return mensaje;

    }

    private String importarTXT(File f) {

        String[][] tmp;
        try {
            tmp = importFromDisk(f,"#");
        } catch (Exception ex) {
            return "No se ha podido importar el archivo de texto %n";
        }

        for (String[] linea : tmp) {
            if (f.getName().startsWith("peliculas")) {
                peliculas.add(Pelicula.factory(linea));
            } else {
                actores.add(Actor.factory(linea));
            }
        }
        
        return "";
    }
}
