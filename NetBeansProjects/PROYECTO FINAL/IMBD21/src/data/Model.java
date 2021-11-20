package data;

// import data.data_films.*;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import static com.coti.tools.OpMat.*;


public class Model {

    Filmoteca film = new Filmoteca();

    List<Pelicula> peliculas = new ArrayList<>();
    List<Actor> actores = new ArrayList<>();
    List<Director> directores = new ArrayList<>();
    

    public String importarArchivo(File f) {
        
        if (f.getName().startsWith("peliculas")) {
            return importarPeliculas(f);
        } else if (f.getName().startsWith("directores")) {
            return importarDirectores(f);
        } else if (f.getName().startsWith("actores")) {
            return importarActores(f);
        } else {
            return "%nERROR: fallo inesperado de lectura.%n";
        }
    } // importarArchivo



    private String importarActores(File f) {

        String[][] tmp;

        if (f.getName().endsWith(".txt")) {        
            try {
                tmp = importFromDisk(f, "#");
            } catch (Exception ex) {
                return "%nERROR: Archivo en formato no esperado%n";
            }

            for (String[] linea : tmp) {
                if (linea.length != 5)  {
                    return "%nERROR: Archivo en formato no esperado%n";
                }
                actores.add(Actor.factory(linea));
            }
            this.film.setActores(actores);

            return "";
        } else {
            // POR TERMINAR. ARCHIVO EN FORMATO BINARIO
            return "";
        }
        
    } // importarActores
    

    private String importarDirectores(File f) {
        
        String[][] tmp;

        if (f.getName().endsWith(".txt")) {        
            try {
                tmp = importFromDisk(f, "#");
            } catch (Exception ex) {
                return "%nERROR: Archivo en formato no esperado%n";
            }

            for (String[] linea : tmp) {
                if (linea.length != 5)  {
                    return "%nERROR: Archivo en formato no esperado%n";
                }
                directores.add(Director.factory(linea));
            }
            this.film.setDirectores(directores);

            return "";
        } else {
            // POR TERMINAR. ARCHIVO EN FORMATO BINARIO
            return "";
        }
    } // importarDirectores

    private String importarPeliculas(File f) {
            
        String[][] tmp;

        if (f.getName().endsWith(".txt")) {        
            try {
                tmp = importFromDisk(f, "#");
            } catch (Exception ex) {
                return "%nERROR: Archivo en formato no esperado%n";
            }

            for (String[] linea : tmp) {
                if (linea.length != 12)  {
                    return "%nERROR: Archivo en formato no esperado%n";
                }
                peliculas.add(Pelicula.factory(linea));
            }
            this.film.setPeliculas(peliculas);

            return "";
        } else {
            // POR TERMINAR. ARCHIVO EN FORMATO BINARIO
            return "";
        }
    } // importarPeliculas
    
    
} // end class Model
