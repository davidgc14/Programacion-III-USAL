package data;


// pendiente de revisar la estructura del codigo para poder meter en subpaquete
// import data.data_films.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;

import com.coti.tools.Rutas;

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
        } else if (f.getName().endsWith(".bin")) {
                Path path = this.film.getPathPorNombre("peliculas");
                if (path == null) {
                    return "%nERROR: No se encontró el archivo de películas.bin%n";
                } else {
                    try {
                        FileInputStream fis = new FileInputStream(path.toFile());
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        ObjectInputStream ois = new ObjectInputStream(bis);
                        this.film.setPeliculas((List<Pelicula>) ois.readObject());
                        ois.close();
                    } catch (Exception ex) {
                        return "%nERROR: Peliculas en formato no esperado (BINARIO)%n";
                    }
                }
            return "";
        } else {
            return "%nERROR: peliculas en formato no reconocido";
        }
    } // importarPeliculas
    
    private String importarActores(File f) {

        String[][] tmp;

        if (f.getName().endsWith(".txt")) {        
            try {
                tmp = importFromDisk(f, "#");
            } catch (Exception ex) {
                return "%nERROR: Actores en formato no esperado%n";
            }
            
            for (String[] linea : tmp) {
                if (linea.length != 5)  {
                    return "%nERROR: Actores con lineas de longitud no esperada%n";
                }
                this.film.addActor(Actor.factory(linea));
            }

            return "";
        } else if (f.getName().endsWith(".bin")) {
                Path path = this.film.getPathPorNombre("actores");
                if (path == null) {
                    return "%nERROR: No se encontró el archivo de actores.bin%n";
                } else {
                    try {
                        FileInputStream fis = new FileInputStream(path.toFile());
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        ObjectInputStream ois = new ObjectInputStream(bis);
                        this.film.setActores((List<Actor>) ois.readObject());
                        ois.close();
                    } catch (Exception ex) {
                        return "%nERROR: Actores en formato no esperado (BINARIO)%n";
                    }
                }
            return "";
        } else {
            return "%nERROR: actores en formato no reconocido";
        }        
    } // importarActores
    
    private String importarDirectores(File f) {
        
        String[][] tmp;

        if (f.getName().endsWith(".txt")) {        
            try {
                tmp = importFromDisk(f, "#");
            } catch (Exception ex) {
                return "%nERROR: Directores en formato no esperado%n";
            }
            
            for (String[] linea : tmp) {
                if (linea.length != 5)  {
                    return "%nERROR: Directores con lineas de longitud no esperada%n";
                }
                this.film.addDirector(Director.factory(linea));
            }

            return "";
        } else if (f.getName().endsWith(".bin")) {
                Path path = this.film.getPathPorNombre("directores");
                if (path == null) {
                    return "%nERROR: No se encontró el archivo de directores.bin%n";
                } else {
                    try {
                        FileInputStream fis = new FileInputStream(path.toFile());
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        ObjectInputStream ois = new ObjectInputStream(bis);
                        this.film.setDirectores((List<Director>) ois.readObject());
                        ois.close();
                    } catch (Exception ex) {
                        return "%nERROR: Directores en formato no esperado (BINARIO)%n";
                    }
                }
            return "";
        } else {
            return "%nERROR: directores en formato no reconocido";
        }
    } // importarDirectores
    

    public String importarPathArchivos() {
        String[] lista = {"peliculas", "directores", "actores"};
        try {
            for (String s : lista) {
                this.film.addPath(Rutas.pathToFileInFolderOnDesktop("IMBD21", s + ".bin"));
            }
        } catch (Exception ex) {
            return "%nERROR: Problema al cargar el archivo binario%n";
        }
        
        return "";
    } // importarPathArchivo



    // EXPORTACION DE DATOS ---------------------------------------------------

    public void exportarDatos() {
        exportarPeliculas(this.film.getPathPorNombre("peliculas"));
        exportarDirectores(this.film.getPathPorNombre("directores"));
        exportarActores(this.film.getPathPorNombre("actores"));
    } // exportarDatos

    private void exportarPeliculas(Path path) {
        
        try {
            FileOutputStream fos = new FileOutputStream(path.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this.film.getPeliculas());
            oos.close();
        } catch (Exception ex) {
            System.out.printf("%nERROR: fallo inesperado de exportacion de peliculas a binario (MODEL)%n");
            System.out.println(ex);
        }
    } // exportarPeliculas

    private void exportarDirectores(Path path) {
        
        try {
            FileOutputStream fos = new FileOutputStream(path.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this.film.getDirectores());
            oos.close();
        } catch (Exception ex) {
            System.out.printf("%nERROR: fallo inesperado de exportacion de directores a binario (MODEL)%n");
        }
    } // exportarDirectores

    private void exportarActores(Path path) {
        
        try {
            FileOutputStream fos = new FileOutputStream(path.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this.film.getActores());
            oos.close();
        } catch (Exception ex) {
            System.out.printf("%nERROR: fallo inesperado de exportacion de actores a binario (MODEL)%n");
        }
    } // exportarActores



    // EXPORTACION DE ARCHIVOS ------------------------------------------------

    public void exportarCOL() {
        File f = Rutas.fileToFileInFolderOnDesktop("IMBD21", "Directores_Exportado.col");

        List<String> tmp = new ArrayList<>();

        for (Director d : this.film.getDirectores()) {
            tmp.add(d.toStringForExport());
        }

        try {
            Files.write(f.toPath(), tmp, Charset.forName("UTF-8"), StandardOpenOption.CREATE);
        } catch (Exception ex) {
            System.out.println("%nERROR: Problema al exportar el archivo COL%n");
        }
    }

    public void exportarHTML() {
        File f = Rutas.fileToFileInFolderOnDesktop("IMBD21", "Peliculas_Exportado.html");

        try {
            PrintWriter pw = new PrintWriter(f);
            pw.printf("<!DOCTYPE html>%n"
                    + "<HTML>%n"
                    + "<HEAD>%n"
                    + "<meta charset=\"UTF-8\">%n"
                    + "<TITLE>Peliculas</TITLE>%n"
                    // + "<H1>Listado de Películas</H1>"
                    + "</HEAD>%n"
                    + "<BODY>%n");
            pw.printf("<TABLE BORDER=1>%n");
            pw.printf("%s%n", Pelicula.encabezado());

            for (Pelicula p : this.film.getPeliculas()) {
                pw.printf("%s%n", p.filaDeHTML());
            }

            pw.printf("</TABLE>%n</BODY>%n</HTML>%n");
            pw.close(); 

        } catch (Exception ex) {
            System.out.println("%nERROR: Problema al exportar el archivo HTML%n");
        }
    }


    // MENU PELICULAS ---------------------------------------------------------
    
    public void agregarPelicula(String[] linea) {
        this.film.addPelicula(Pelicula.factory(linea));
    } // agregarPelicula
    
    public void modificarPelicula(String nombrePeli, int id, String nuevo) {

        Pelicula peliculaEncontrada = null;
        for (Pelicula p : this.film.getPeliculas()) {
            if (p.getTitulo().equalsIgnoreCase(nombrePeli)) {
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
            if (p.getTitulo().equalsIgnoreCase(nombrePeli)) {
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
            if (p.getTitulo().equalsIgnoreCase(nombrePeli)) {
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
            if (d.getNombre().equalsIgnoreCase(nombreDir)) {
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
            if (d.getNombre().equalsIgnoreCase(nombreDir)) {
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
            if (a.getNombre().equalsIgnoreCase(nombreAct)) {
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
            if (a.getNombre().equalsIgnoreCase(nombreAct)) {
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



    // MENU LISTADOS ---------------------------------------------------------

    public String[][] listarPeliculas() {
        List<Pelicula> listaPeliculas = this.film.getPeliculas();

        listaPeliculas.sort(Comparator.comparing(Pelicula::getTitulo));

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
    } // listadoPeliculas

    public String[][] listarDirectores() {
        List<Director> listaDirectores = this.film.getDirectores();

        listaDirectores.sort(Comparator.comparing(Director::getNacionalidad).thenComparing(Director::getFechaNacimiento));

        String[][] tmp = new String[listaDirectores.size() + 1][4];
        
        tmp[0][0] = "NOMBRE";
        tmp[0][1] = "FECHA NACIMIENTO";
        tmp[0][2] = "NACIONALIDAD";
        tmp[0][3] = "OCUPACION";

        for (int i = 0; i < listaDirectores.size(); i++) {
            tmp[i+1][0] = listaDirectores.get(i).getNombre();
            tmp[i+1][1] = listaDirectores.get(i).getFechaNacimiento();
            tmp[i+1][2] = listaDirectores.get(i).getNacionalidad();
            tmp[i+1][3] = listaDirectores.get(i).getOcupacion();
        }

        return tmp;
    } // listadoDirectores

    public String[][] listarActores() {
        List<Actor> listaActores = this.film.getActores();

        listaActores.sort(Comparator.comparing(Actor::getDebut).thenComparing(Actor::getNombre));
        // nombre, fechaNacimiento, nacionalidad, debut
        
        String[][] tmp = new String[listaActores.size() + 1][4];
        
        tmp[0][0] = "NOMBRE";
        tmp[0][1] = "FECHA NACIMIENTO";
        tmp[0][2] = "NACIONALIDAD";
        tmp[0][3] = "DEBUT";

        for (int i = 0; i < listaActores.size(); i++) {
            tmp[i+1][0] = listaActores.get(i).getNombre();
            tmp[i+1][1] = listaActores.get(i).getFechaNacimiento();
            tmp[i+1][2] = listaActores.get(i).getNacionalidad();
            tmp[i+1][3] = listaActores.get(i).getDebut();
        }

        return tmp;
    } // listadoActores


} // end class Model
