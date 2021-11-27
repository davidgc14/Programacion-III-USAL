package view;

import controller.Controller;

import static com.coti.tools.Esdia.*;

import com.coti.tools.Rutas;
import java.io.File;

import static com.coti.tools.DiaUtil.clear;


public class View {

    Controller c = new Controller();
    

    public void runMenu(String menu) {
        
        System.out.printf("%n%nBIENVENIDO AL PROGRAMA DE GESTIÓN DE PELÍCULAS%n%n");

        String option;
        boolean salir = this.inicioPrograma();

        while (!salir) {

            clear();
            
            option = readString(menu);

            switch (option.toLowerCase()) {
                case "1" -> this.menuArchivos();
                case "2" -> this.menuPeliculas();
                case "3" -> this.menuDirectores();
                case "4" -> this.menuActores();
                case "5" -> this.menuListados();
                case "q" -> {this.cierrePrograma(); salir = true;}
                default  -> System.out.printf("%nOpción incorrecta%n");
            }
        } // end while
        
    } // RUN MENU


    /*
    Este metodo se encarga de leer los datos del archivo, y en caso de que 
    el archivo no esté o no exista, fuerza la salida del programa.
    */
    private boolean inicioPrograma() {
        boolean salir = false;

        // importamos las rutas del path
        if (c.importarPathArchivos().equals("")) {
            System.out.printf(c.importarPathArchivos());
            // salir = true;
        }

        System.out.printf("Importando archivos...%n%n");
        File f_peliculas, f_actores, f_directores;
        
        // Rutas de los archivos (si existen .bin)
        f_peliculas = Rutas.fileToFileInFolderOnDesktop("IMBD21", "peliculas.bin");
        f_actores = Rutas.fileToFileInFolderOnDesktop("IMBD21", "actores.bin");
        f_directores = Rutas.fileToFileInFolderOnDesktop("IMBD21", "directores.bin");

        String error_peliculas, error_actores, error_directores;

        // Si alguno de los archivos no existe, buscamos con extensión .txt
        if (!f_peliculas.exists()) {
            
            f_peliculas = Rutas.fileToFileInFolderOnDesktop("IMBD21", "peliculas.txt");
            if (!f_peliculas.exists()) {
                System.out.printf("%nNo se encontró el archivo de películas.%n");
                salir = true;
            } else {
                error_peliculas = c.importarArchivo(f_peliculas);
                if (!error_peliculas.isEmpty()) {
                    System.out.printf(error_peliculas);
                    salir = true;
                }
            }

            
        } else {
            error_peliculas = c.importarArchivo(f_peliculas);
            if (!error_peliculas.isEmpty()) {
                System.out.printf(error_peliculas);
                salir = true;
            }
        }

        if (!f_actores.exists()) {
            
            f_actores = Rutas.fileToFileInFolderOnDesktop("IMBD21", "actores.txt");

            if (!f_actores.exists()) {
                System.out.printf("%nNo se encontró el archivo de actores.%n");
                salir = true;
            } else {
                error_actores = c.importarArchivo(f_actores);
                if (!error_actores.isEmpty()) {
                    System.out.printf(error_actores);
                    salir = true;
                }
            }
        } else {
            error_actores = c.importarArchivo(f_actores);
            if (!error_actores.isEmpty()) {
                System.out.printf(error_actores);
                salir = true;
            }
        }

        if (!f_directores.exists()) {
            
            f_directores = Rutas.fileToFileInFolderOnDesktop("IMBD21", "directores.txt");

            if (!f_directores.exists()) {
                System.out.printf("%nNo se encontró el archivo de directores.%n");
                salir = true;
            } else {
                error_directores = c.importarArchivo(f_directores);
                if (!error_directores.isEmpty()) {
                    System.out.printf(error_directores);
                    salir = true;
                }
            }
        } else {
            error_directores = c.importarArchivo(f_directores);
            if (!error_directores.isEmpty()) {
                System.out.printf(error_directores);
                salir = true;
            }
        }

        return salir;
    }

    // METODOS DEL RUNMENU  ---------------------------------------------------

    ViewAux vaux = new ViewAux(c);
    
    private void menuArchivos() {

        String option;
        boolean salir = false;

        do {
            option = readString("%n1.- Exportar lista de directores por columnas"
                            + "%n2.- Exportar peliculas en formato html"
                            + "%nq.- Salir del menu ARCHIVOS"
                            + "%n%n       >       ");

            switch (option.toLowerCase()) {
                case "1" -> vaux.exportarArchivoColumnas();
                case "2" -> vaux.exportarArchivoHTML();
                case "q" -> salir = true;
                default  -> System.out.println("Opcion no valida");
            }
        } while (!salir);
    } // end menuArchivos


    private void menuPeliculas() {

        String option;
        boolean salir = false;

        do {
            option = readString("%n1.- Agregar pelicula"
                            + "%n2.- Modificar pelicula"
                            + "%n3.- Eliminar pelicula"
                            + "%n4.- Consultar pelicula"
                            + "%nq.- Salir del menu PELICULAS"
                            + "%n%n       >       ");

            switch (option.toLowerCase()) {
                case "1" -> vaux.agregarPelicula();
                case "2" -> vaux.modificarPelicula();
                case "3" -> vaux.eliminarPelicula();
                case "4" -> vaux.consultarPelicula();
                case "q" -> salir = true;
                default  -> System.out.println("Opcion no valida");
            }
        } while (!salir);
    } // end menuPeliculas


    private void menuDirectores() {

        String option;
        boolean salir = false;

        do {
            option = readString("%n1.- Agregar director"
                            + "%n2.- Modificar director"
                            + "%n3.- Eliminar director"
                            + "%nq.- Salir del menu DIRECTORES"
                            + "%n%n       >       ");

            switch (option.toLowerCase()) {
                case "1" -> vaux.agregarDirector();
                case "2" -> vaux.modificarDirector();
                case "3" -> vaux.eliminarDirector();
                case "q" -> salir = true;
                default  -> System.out.println("Opcion no valida");
            }
        } while (!salir);
    } // end menuDirectores


    private void menuActores() {

        String option;
        boolean salir = false;

        do {
            option = readString("%n1.- Agregar actor"
                            + "%n2.- Modificar actor"
                            + "%n3.- Eliminar actor"
                            + "%n4.- Consultar actor"
                            + "%nq.- Salir del menu ACTORES"
                            + "%n%n       >       ");

            switch (option.toLowerCase()) {
                case "1" -> vaux.agregarActor();
                case "2" -> vaux.modificarActor();
                case "3" -> vaux.eliminarActor();
                case "4" -> vaux.consultarPeliculasActor();
                case "q" -> salir = true;
                default  -> System.out.println("Opcion no valida");
            }
        } while (!salir);
    } // end menuActores


    private void menuListados() {

        String option;
        boolean salir = false;

        do {
            option = readString("%n1.- Listado de peliculas"
                            + "%n2.- Listado de directores"
                            + "%n3.- Listado de actores"
                            + "%nq.- Salir del menu LISTADOS"
                            + "%n%n       >       ");

            switch (option.toLowerCase()) {
                case "1" -> vaux.listadoPeliculas();
                case "2" -> vaux.listadoDirectores();
                case "3" -> vaux.listadoActores();
                case "q" -> salir = true;
                default  -> System.out.println("Opcion no valida");
            }
        } while (!salir);
    } // end menuListados

    private void cierrePrograma() {
        System.out.printf("%n%nGracias por usar el programa.%n%n");
        try {
            c.exportarDatos();
        } catch (Exception ex) {
            System.out.printf("%nERROR: no se han podido guardar los datos en binario. Se perderán todas las modificaciones.%n");
        }
        
    } // end cierrePrograma

} // end View
