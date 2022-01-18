package data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public String save(File f1, File f2) {

        String mensaje = "Exportando archivos...%n";

        try {
            FileOutputStream fos = new FileOutputStream(f1);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(peliculas);
            oos.close();
            mensaje = mensaje + "%nArchivo peliculas guardado correctamente%n";

        } catch (Exception ex) {
            mensaje.concat("Error en la exportacion de peliculas %n");
        }

        try {
            FileOutputStream fos = new FileOutputStream(f2);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(actores);
            oos.close();
            mensaje = mensaje + "%nArchivo actores guardado correctamente%n";

        } catch (Exception ex) {
            mensaje.concat("Error en la exportacion de actores %n");
        }

        

        return mensaje;
    }

    // menu peliculas ---------------------------------------------------

    public String addPelicula(String[] datos) {
       
        try {
           peliculas.add(Pelicula.factory(datos));
        } catch (Exception ex) {
            return "ERROR: no se pudo guardar la pelicula. Revise código e inténtelo más tarde";
        }
 
        return "";
    }

    public String deletePelicula(String nombre) {

        Pelicula pel = verSiEstaPelicula(nombre);
        if (pel != null) {
            peliculas.remove(pel);
        } else {
            return "ERROR: pelicula no encontrada";
        }
        return "";
    }

    public String searchPelicula(String nombre) {

        Pelicula pel = verSiEstaPelicula(nombre);
        if (pel != null) {
                String pelToString = pel.getTitulo() + "%n" 
                                    + pel.getAño() + "%n"
                                    + pel.getDuracion() + "%n"
                                    + pel.getGenero() + "%n"
                                    + pel.getSinopsis() + "%n"
                                    + pel.getPais() + "%n%n";
            
            return pelToString;
        } else {
            return "ERROR: pelicula no encontrada";
        }
    }

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


    // menu auxiliar ---------------------------------------------------

    private Pelicula verSiEstaPelicula(String nombre) {
        
        for (int i = 0 ; peliculas.size() > i ; i++) {
            if (peliculas.get(i).getTitulo().equalsIgnoreCase(nombre)) {
                return peliculas.get(i);
            }
        }
        return null;
    }
}
