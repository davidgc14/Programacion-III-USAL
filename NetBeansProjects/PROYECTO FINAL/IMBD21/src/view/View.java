package view;

import controller.Controller;

import static com.coti.tools.Esdia.*;


public class View {

    Controller c = new Controller();
    

    public void runMenu(String menu) {
        
        String option;
        boolean salir = this.inicioPrograma();

        while (!salir) {
            
            option = readString(menu);

            switch (option.toLowerCase()) {
                case "1" -> this.menuArchivos();
                case "2" -> this.menuPeliculas();
                case "3" -> this.menuDirectores();
                case "4" -> this.menuActores();
                case "5" -> this.menuListados();
                case "q" -> salir = true;
                default  -> System.out.println("Opción incorrecta");
            }
        } // end while
    } // RUN MENU


    /*
    Este metodo se encarga de leer los datos del archivo, y en caso de que 
    el archivo no esté o no exista, fuerza la salida del programa.
    */
    private boolean inicioPrograma() {
        boolean salir = false;

        // PENDIENTE

        return salir;
    }

    // METODOS DEL RUNMENU  ---------------------------------------------------

    private void menuArchivos() {

        String option;
        boolean salir = false;

        do {
            option = readString("%n1.- Exportar por columnas"
                            + "%n2.- Exportar formato html"
                            + "%nq.- Salir del menu ARCHIVOS"
                            + "%n%n       >       ");

            switch (option.toLowerCase()) {
                case "1" -> ViewAux.exportarArchivoColumnas();
                case "2" -> ViewAux.exportarArchivoHTML();
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
                case "1" -> ViewAux.agregarPelicula();
                case "2" -> ViewAux.modificarPelicula();
                case "3" -> ViewAux.eliminarPelicula();
                case "4" -> ViewAux.consultarPelicula();
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
                case "1" -> ViewAux.agregarDirector();
                case "2" -> ViewAux.modificarDirector();
                case "3" -> ViewAux.eliminarDirector();
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
                case "1" -> ViewAux.agregarActor();
                case "2" -> ViewAux.modificarActor();
                case "3" -> ViewAux.eliminarActor();
                case "4" -> ViewAux.consultarActor();
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
                case "1" -> ViewAux.listadoPeliculas();
                case "2" -> ViewAux.listadoDirectores();
                case "3" -> ViewAux.listadoActores();
                case "q" -> salir = true;
                default  -> System.out.println("Opcion no valida");
            }
        } while (!salir);
    } // end menuListados




} // end View
