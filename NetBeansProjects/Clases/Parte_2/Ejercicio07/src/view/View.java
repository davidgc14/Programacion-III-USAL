package view;

// REVISADO Y CORRECTO

import static com.coti.tools.Esdia.*;
// import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.OpMat.*; 

import controller.Controller;

public class View {
    
    Controller c = new Controller();

    public void runMenu(String menu) {
        String opcion;

        boolean salir = false;

        do {
            opcion = readString(menu);
            switch (opcion) {
                case "1" -> this.importarListaGeneral();
                case "2" -> this.mostrarListaGeneral();
                case "3" -> this.mostrarListaBajaAsistencia();
                case "4" -> this.ordenarListaGeneral();
                case "5" -> this.exportarListaGeneral();
                case "6" -> this.exportarListaBajaAsistencia();
                case "q" -> salir = siOno("¿Desea salir?");
                default  -> System.out.printf("%n%nOpción incorrecta%n%n");
            }
        } while (!salir);
    }

    private void importarListaGeneral() {
        underline2("Importar lista de Alumnos");
        
        try {
            c.obtenerTablaGeneral();
            System.out.printf("%nLista importada. %d registros importados correctamente%n", c.obtenerTablaGeneral().length);
        } catch (Exception e) {
            System.out.printf("%n%nERROR: no fue posible importar la lista%n%n");
        }
    }


    private void mostrarListaGeneral() {
        underline2("Mostrar lista general de alumnos");
        String[][] tmp = c.obtenerTablaGeneral(); // aqui se puede usar tambien var tmp = c.obtenerTablaGeneral();

        try {
            printToScreen3(tmp);
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo mostrar la lista%n%n");
        }

    }

    private void mostrarListaBajaAsistencia() {
        underline2("Mostrar lista de alumnos con baja asistencia");
        String[][] tmp = c.obtenerTablaBajaAsistencia();

        try {
            printToScreen3(tmp);
            System.out.printf("%n%nLista de alumnos con baja asistencia%n%n");
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo obtener lista de alumnos con baja asistencia%n%n");
        }
    }

    private void ordenarListaGeneral() {
        underline2("Ordenar la lista general de apellidos y nombre");
        c.ordenarListaGeneral();
    }

    private void exportarListaGeneral() {
        underline2("Exportar lista general de alumnos");
        try {
            c.exportarTablaGeneral();
            System.out.printf("%nLista exportada correctamente%n");
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo exportar la lista%n%n");
        }
    }

    private void exportarListaBajaAsistencia() {
        underline2("Exportar lista de alumnos con asistencia");
        
        try {
            c.exportarTablaBajaAsistencia();
            System.out.printf("%nLista exportada correctamente%n");
        } catch (Exception ex) {
            System.out.printf("%n%nERROR: no se pudo exportar la lista%n%n");
        }
    }

}
