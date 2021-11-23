package data;

// import data.data_films.*;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import static com.coti.tools.OpMat.*;


public class Model {
    
    // private Filmoteca film = new Filmoteca();

    // unused
    private List<Pelicula> peliculas;
    private List<Actor> actores;
    private List<Director> directores;
    // private List<String> rutas = new ArrayList<>();
    

    // IMPORTACION DE DATOS

    public String importarArchivo(File f) {
        
        if (f.getName().startsWith("peliculas")) {
            return importarPeliculas(f);
        } else if (f.getName().startsWith("directores")) {
            return importarDirectores(f);
        } else if (f.getName().startsWith("actores")) {
            return importarActores(f);
        } else {
            return "%nERROR: fallo inesperado de lectura (MODEL)%n";
        }
    } // importarArchivo

    private String importarActores(File f) {

        actores = new ArrayList<>();
        String[][] tmp;

        if (f.getName().endsWith(".txt")) {        
            try {
                tmp = importFromDisk(f, "#");
            } catch (Exception ex) {
                return "%nERROR: Actor en formato no esperado%n";
            }

            for (String[] linea : tmp) {
                if (linea.length != 5)  {
                    return "%nERROR: Actor con lineas de longitud no esperada%n";
                }
                Actor act = Actor.factory(linea);
                // this.film.addActor(Actor.factory(linea));
                actores.add(act);
            }

            return "";
        } else {
            // POR TERMINAR. ARCHIVO EN FORMATO BINARIO
            return "";
        }
        
    } // importarActores
    
    private String importarDirectores(File f) {
        
        directores = new ArrayList<>();
        String[][] tmp;

        if (f.getName().endsWith(".txt")) {        
            try {
                tmp = importFromDisk(f, "#");
            } catch (Exception ex) {
                return "%nERROR: Director en formato no esperado%n";
            }

            for (String[] linea : tmp) {
                if (linea.length != 5)  {
                    return "%nERROR: Director con lineas de longitud no esperada%n";
                }
                Director dir = Director.factory(linea);
                // this.film.addDirector(Director.factory(linea));
                directores.add(dir);
            }

            return "";
        } else {
            // POR TERMINAR. ARCHIVO EN FORMATO BINARIO
            return "";
        }
    } // importarDirectores

    private String importarPeliculas(File f) {
        
        peliculas = new ArrayList<>();
        String[][] tmp;

        if (f.getName().endsWith(".txt")) {        
            try {
                tmp = importFromDisk(f, "#");
            } catch (Exception ex) {
                return "%nERROR: Peliculas en formato no esperado%n";
            }
            
            for (String[] linea : tmp) {
                if (linea.length != 11)  {
                    return "%nERROR: Peliculas con lineas de longitud no esperada%n";
                }
                Pelicula pel = Pelicula.factory(linea);
                // this.film.addPelicula(Pelicula.factory(linea));
                peliculas.add(pel);
            }

            return "";
        } else {
            // POR TERMINAR. ARCHIVO EN FORMATO BINARIO
            return "Está en binario";
        }
    } // importarPeliculas
    

    
    // MENU PELICULAS 
    
    public void agregarPelicula(String[] linea) {
        peliculas.add(Pelicula.factory(linea));
    } // agregarPelicula
    
    public void modificarPelicula(String nombrePeli, int id) {
        
    } // modificarPelicula

    public boolean verSiExistePelicula(String nombrePeli) {
        
        String titulo;
        for (Pelicula peli : peliculas) {
            titulo = peli.getTitulo();
            if (titulo.equalsIgnoreCase(nombrePeli)) {
                
                return true;
            }
        }
        return false;
    } // verSiExistePelicula

} // end class Model
