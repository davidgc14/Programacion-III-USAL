package data;

// import data.data_films.*;

import java.io.File;
// import java.util.List;
// import java.util.ArrayList;
import java.util.List;

import static com.coti.tools.OpMat.*;


public class Model {
    
    private Filmoteca film = new Filmoteca();

    // unused
    // private List<Pelicula> peliculas = new ArrayList<>();
    // private List<Actor> actores = new ArrayList<>();
    // private List<Director> directores = new ArrayList<>();
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
                this.film.addActor(Actor.factory(linea));
            }

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
                return "%nERROR: Director en formato no esperado%n";
            }

            for (String[] linea : tmp) {
                if (linea.length != 5)  {
                    return "%nERROR: Director con lineas de longitud no esperada%n";
                }
                this.film.addDirector(Director.factory(linea));
            }

            return "";
        } else {
            // POR TERMINAR. ARCHIVO EN FORMATO BINARIO
            return "";
        }
    } // importarDirectores


    //  

    private String importarPeliculas(File f) {
            
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
                this.film.addPelicula(Pelicula.factory(linea));
            }

            return "";
        } else {
            // POR TERMINAR. ARCHIVO EN FORMATO BINARIO
            return "Está en binario";
        }
    } // importarPeliculas
    

    
    // MENU PELICULAS 
    
    public void agregarPelicula(String[] linea) {
        this.film.addPelicula(Pelicula.factory(linea));
    } // agregarPelicula
    
    public void modificarPelicula(String nombrePeli, int id, String nuevo) {
        List<Pelicula> pelis = this.film.getPeliculas();

        Pelicula peliculaEncontrada = null;
        for (Pelicula p : pelis) {
            if (p.getTitulo().equals(nombrePeli)) {
                peliculaEncontrada = p;
                break;
            }
        }

        // +1 porque el id empieza en 0
        switch (id + 1) { 
            case 2  -> peliculaEncontrada.setAño(nuevo);
            case 3  -> peliculaEncontrada.setDuracion(nuevo);
            case 4  -> peliculaEncontrada.setPais(nuevo);
            case 6  -> peliculaEncontrada.setGuionista(nuevo);
            case 7  -> peliculaEncontrada.setMusica(nuevo);
            case 9  -> peliculaEncontrada.setProductora(nuevo);
            case 10 -> peliculaEncontrada.setSinopsis(nuevo);
            case 11 -> peliculaEncontrada.setGenero(nuevo);
            default -> System.out.println("ERROR: No se ha podido acceder al parametro encontrado. Es posible que no se pueda modificar");
        }

        System.out.printf("%nParametro de la pelicula modificado con exito%n%n");

           
    } // modificarPelicula


    public boolean verSiExistePelicula(String nombrePeli) {
        
        String titulo;
        for (Pelicula peli : this.film.getPeliculas()) {
            titulo = peli.getTitulo();
            if (titulo.equalsIgnoreCase(nombrePeli)) {
                
                return true;
            }
        }
        return false;
    } // verSiExistePelicula

} // end class Model
