package data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;

import static com.coti.tools.OpMat.*;

public class Model {
    
    private ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    private ArrayList<Actor> actores = new ArrayList<Actor>();

    // importaciones ---------------------------------------------------

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
            mensaje.concat(importarTXT(f));
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


    // menu peliculas ---------------------------------------------------

    public String[][] listarPeliculas() {
        
        peliculas.sort(Comparator.comparing(Pelicula::getAño).thenComparing(Pelicula::getTitulo));
        


        String[][] tmp = new String[peliculas.size() + 1][5];

        tmp[0][0] = "TITULO";
        tmp[0][1] = "AÑO";
        tmp[0][2] = "DURACION";
        tmp[0][3] = "PAIS";
        tmp[0][4] = "GENERO";

        for(int i=0 ; i < peliculas.size() ; i++) {
            tmp[i+1][0] = peliculas.get(i).getTitulo();
            tmp[i+1][1] = peliculas.get(i).getAño();
            tmp[i+1][2] = peliculas.get(i).getDuracion();
            tmp[i+1][3] = peliculas.get(i).getPais();
            tmp[i+1][4] = peliculas.get(i).getGenero();
            
        }
        return tmp;
    }
}
