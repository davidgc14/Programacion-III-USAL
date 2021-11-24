package data;

// pendiente de revisar la estructura del codigo para poder meter en subpaquete
// import data.data_films.*;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import static com.coti.tools.OpMat.*;


public class Model {
    
    private Filmoteca film = new Filmoteca();

    // IMPORTACION DE DATOS ---------------------------------------------------

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
    

    
    // MENU PELICULAS ---------------------------------------------------------
    
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
            default -> {
                System.out.println("ERROR: No se ha podido acceder al parametro encontrado. Es posible que no se pueda modificar");
                return;
            }
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

    public void eliminarPelicula(String nombrePeli) {
        List<Pelicula> pelis = this.film.getPeliculas();

        Pelicula peliculaEncontrada = null;
        for (Pelicula p : pelis) {
            if (p.getTitulo().equals(nombrePeli)) {
                peliculaEncontrada = p;
                break;
            }
        }

        pelis.remove(peliculaEncontrada);
        System.out.printf("%nPelicula eliminada con exito%n%n");
    } // eliminarPelicula
    // mejorar!!!
    public String[][] consultarPelicula(String nombrePeli) {
        List<Pelicula> pelis = this.film.getPeliculas();

        Pelicula peliculaEncontrada = null;
        for (Pelicula p : pelis) {
            if (p.getTitulo().equals(nombrePeli)) {
                peliculaEncontrada = p;
                break;
            }
        }
        // titulo, año, duracion, pais,[] direccion, guionista, musica,[] reparto, productora, sinopsis, genero;
        String[][] tmp = new String[11][1];
        tmp[0][0]  = peliculaEncontrada.getTitulo();
        tmp[1][0]  = peliculaEncontrada.getAño();
        tmp[2][0]  = peliculaEncontrada.getDuracion();
        tmp[3][0]  = peliculaEncontrada.getPais();
        tmp[4]     = peliculaEncontrada.getDireccion();
        tmp[5][0]  = peliculaEncontrada.getGuionista();
        tmp[6][0]  = peliculaEncontrada.getMusica();
        tmp[7]     = peliculaEncontrada.getReparto();
        tmp[8][0]  = peliculaEncontrada.getProductora();
        tmp[9][0]  = peliculaEncontrada.getSinopsis();
        tmp[10][0] = peliculaEncontrada.getGenero();

        return tmp;
    } // consultarPelicula



    // MENU DIRECTORES ---------------------------------------------------------

    public void agregarDirector(String[] linea) {
        this.film.addDirector(Director.factory(linea));
    } // agregarDirector

    public void modificarDirector(String nombreDir, int id, String nuevo) {
        List<Director> directores = this.film.getDirectores();

        Director directorEncontrado = null;
        for (Director d : directores) {
            if (d.getNombre().equals(nombreDir)) {
                directorEncontrado = d;
                break;
            }
        }

        // +1 porque el id empieza en 0
        switch (id + 1) { 
            case 2  -> directorEncontrado.setFechaNacimiento(nuevo);
            case 3  -> directorEncontrado.setNacionalidad(nuevo);
            case 4  -> directorEncontrado.setOcupacion(nuevo);
            default -> {
                System.out.println("ERROR: No se ha podido acceder al parametro encontrado. Es posible que no se pueda modificar");
                return;
            }
        }

        System.out.printf("%nParametro del director modificado con exito%n%n");
    } // modificarDirector

    public boolean verSiExisteDirector(String nombreDir) {
        
        String nombre;
        for (Director dir : this.film.getDirectores()) {
            nombre = dir.getNombre();
            if (nombre.equalsIgnoreCase(nombreDir)) {
                
                return true;
            }
        }
        return false;
    } // verSiExisteDirector

    public void eliminarDirector(String nombreDir) {
        List<Director> directores = this.film.getDirectores();

        Director directorEncontrado = null;
        for (Director d : directores) {
            if (d.getNombre().equals(nombreDir)) {
                directorEncontrado = d;
                break;
            }
        }

        directores.remove(directorEncontrado);
        System.out.printf("%nDirector eliminado con exito%n%n");
    } // eliminarDirector



    // MENU ACTORES ---------------------------------------------------------

    public void agregarActor(String[] linea) {
        this.film.addActor(Actor.factory(linea));
    } // agregarActor

    public void modificarActor(String nombreAct, int id, String nuevo) {
        List<Actor> actores = this.film.getActores();

        Actor actorEncontrado = null;
        for (Actor a : actores) {
            if (a.getNombre().equals(nombreAct)) {
                actorEncontrado = a;
                break;
            }
        }

        // +1 porque el id empieza en 0
        switch (id + 1) { 
            case 2  -> actorEncontrado.setFechaNacimiento(nuevo);
            case 3  -> actorEncontrado.setNacionalidad(nuevo);
            case 4  -> actorEncontrado.setDebut(nuevo);
            default -> {
                System.out.println("ERROR: No se ha podido acceder al parametro encontrado. Es posible que no se pueda modificar");
                return;
            }
        }

        System.out.printf("%nParametro del actor modificado con exito%n%n");
    } // modificarActor

    public boolean verSiExisteActor(String nombreAct) {
        
        String nombre;
        for (Actor act : this.film.getActores()) {
            nombre = act.getNombre();
            if (nombre.equalsIgnoreCase(nombreAct)) {
                
                return true;
            }
        }
        return false;
    } // verSiExisteActor

    public void eliminarActor(String nombreAct) {
        List<Actor> actores = this.film.getActores();

        Actor actorEncontrado = null;
        for (Actor a : actores) {
            if (a.getNombre().equals(nombreAct)) {
                actorEncontrado = a;
                break;
            }
        }

        actores.remove(actorEncontrado);
        System.out.printf("%nActor eliminado con exito%n%n");
    } // eliminarActor

    public String[][] peliculasActorOrdenadas(String nombreActor) {
        List<Actor> listaActores = this.film.getActores();

        Actor actorEncontrado = null;
        for (Actor a : listaActores) {
            if (a.getNombre().equalsIgnoreCase(nombreActor)) {
                actorEncontrado = a;
                break;
            }
        }

        // aqui tengo ya la lista de peliculas del actor
        String[] peliculasActor = actorEncontrado.getPeliculas();

        List<Pelicula> listaPeliculas = new ArrayList<>();

        for (int i = 0; i < peliculasActor.length; i++) {
            listaPeliculas.add(this.film.getPeliculaPorTitulo(peliculasActor[i]));
        }



        
        // ahora necesito ordenarlas por año
        listaPeliculas.sort(Comparator.comparing(Pelicula::getAño));
    
        String[][] tmp = new String[listaPeliculas.size() + 1][5];
        
        tmp[0][0] = "TITULO";
        tmp[0][1] = "AÑO";
        tmp[0][2] = "DURACION";
        tmp[0][3] = "PAIS";
        tmp[0][4] = "GENERO";

        for (int i = 0; i < listaPeliculas.size(); i++) {
            tmp[i+1][0] = listaPeliculas.get(i).getTitulo();
            tmp[i+1][1] = listaPeliculas.get(i).getAño();
            tmp[i+1][2] = listaPeliculas.get(i).getDuracion();
            tmp[i+1][3] = listaPeliculas.get(i).getPais();
            tmp[i+1][4] = listaPeliculas.get(i).getGenero();
        }

        return tmp;
    }
} // end class Model
