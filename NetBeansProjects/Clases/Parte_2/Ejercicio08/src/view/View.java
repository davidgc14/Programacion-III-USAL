package view;

import controller.Controller;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.DiaUtil.*;

import static com.coti.tools.OpMat.printToScreen3;
// import static java.lang.System.out;



public class View {
    
    Controller c = new Controller();

    public void runMenu(String menu) {
        String opcion = readString(menu);

        clear();

        underline2("COntrol de asistencia");

        boolean salir = false;
        do {
            opcion = readString(menu).toLowerCase();
            switch (opcion) {
                case "1" -> this.archivos();
                case "2" -> this.ordenarYmostrar();
                case "3" -> this.listados();
                case "q" -> salir = true; // salir = siOno("¿Desea salir?");
                default -> System.out.printf("%n%nOpcion no valida%n%n");

            } // end switch
        } while (!salir);
        c.cleanUp(); // 
    } // end runMenu

    private void mostrarListaGeneral() {
        underline2("Listado general de alumnos");

        String[][] tmp = c.obtenerTablaGeneral(); 
        
        try {
            printToScreen3(tmp);
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo imprimir la tabla general%n%n");
        }
    } // end mostrarListaGeneral

    private void mostrarListaBajaAsistencia() {
        underline2("Listado de alumnos con baja asistencia");

        String[][] tmp = c.obtenerTablaBajaAsistencia(); 
        
        try {
            printToScreen3(tmp);
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo imprimir la tabla de baja asistencia%n%n");
        }
    } // end mostrarListaBajaAsistencia

    private void exportarListaGeneral() {
        underline2("Exportar listado general de alumnos");
        try {
            c.exportarTablaGeneral();
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo exportar a disco la tabla general%n%n");
        }
    } // end exportarListaGeneral

    private void exportarListaBajaAsistencia() {
        underline2("Exportar listado de alumnos con baja asistencia");
        try {
            c.exportarTablaBajaAsistencia();
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo exportar a disco la tabla de baja asistencia%n%n");
        }
    } // end exportarListaBajaAsistencia

    private void importarListaGeneral() {
        underline2("Importar listado general de alumnos");
        try {
            c.importarListaGeneral();
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo importar la lista general%n%n");
        }
    } // end importarListaGeneral

    private void ordenarPorApellidosYNombre() {
        underline2("Ordenar listado general de alumnos");
        try {
            c.ordenarPorApellidosYNombre();
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo ordenar la tabla general%n%n");
        }
    } // end ordenarListaGeneral

    private void archivos() {

        String menu = "%n1.- Importar lista general"
                + "%n2.- Exportar lista general"
                + "%n3.- Exportar lista baja asistencia"
                + "%nq.- Volver al menú principal"
                + "%n          >     ";

        boolean salir = false;

        String opcion;
        clear();
        underline2("Importacion y Exportacion");

        do {
            opcion = readString(menu).toLowerCase();
            switch (opcion) {
                case "1" -> this.importarListaGeneral();
                case "2" -> this.exportarListaGeneral();
                case "3" -> this.exportarListaBajaAsistencia();
                case "q" -> salir = true;
                default -> System.out.printf("%n%nOpcion no valida%n%n");
            } // end switch
        } while (!salir);

    } // end archivos

    private void ordenarYmostrar() {
            
        String menu = "%n1.- Ordenar por Apellidos y Nombre"
                + "%n2.- Ordenar por DNI"
                + "%n3.- Ordenar por asistencia, apellidos y nombre"
                + "%nq.- Volver al menú principal"
                + "%n          >     ";

        boolean salir = false;

        String opcion;
        clear();
        underline2("Ordenar y Mostrar");

        do {
            opcion = readString(menu).toLowerCase();
            switch (opcion) {
                case "1" -> {
                    this.ordenarPorApellidosYNombre();
                    System.out.println("Lista ordenada por Apellidos y Nombre");
                    this.mostrarListaGeneral();
                }
                case "2" -> {
                    this.ordenarPorDNI();
                    System.out.println("Lista ordenada por DNI");
                    this.mostrarListaGeneral();
                }
                case "3" -> {
                    this.ordenarPorAsistenciaApellidosYNombre();
                    System.out.println("Lista ordenada por asistencia, apellidos y nombre");
                    this.mostrarListaGeneral();
                }
                case "q" -> 
                    salir = true;
                default -> 
                    System.out.printf("%n%nOpcion no valida%n%n");
            } // end switch
        } while (!salir);

    } // end ordenarYmostrar

    private void listados() {
        // mostrar lista general, mostrar lista baja asistencia, volver al menu principal
        String menu = "%n1.- Mostrar lista general"
                + "%n2.- Mostrar lista baja asistencia"
                + "%nq.- Volver al menú principal"
                + "%n          >     ";
        
        boolean salir = false;

        String opcion;
        clear();
        underline2("Listados");

        do {
            opcion = readString(menu).toLowerCase();
            switch (opcion) {
                case "1" -> this.mostrarListaGeneral();
                case "2" -> this.mostrarListaBajaAsistencia();
                case "q" -> salir = true;
                default -> System.out.printf("%n%nOpcion no valida%n%n");
            } // end switch
        } while (!salir);
    } // end listados

    private void ordenarPorDNI() {
        underline2("Ordenar listado general de alumnos por DNI");
        try {
            c.ordenarPorDNI();
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo ordenar la tabla general%n%n");
        }
    } // end ordenarPorDNI
    
    private void ordenarPorAsistenciaApellidosYNombre() {
        underline2("Ordenar listado general de alumnos por asistencia, apellidos y nombre");
        try {
            c.ordenarPorAsistenciaApellidosYNombre();
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo ordenar la tabla general%n%n");
        }
    } // end ordenarPorAsistenciaApellidosYNombre

}    
