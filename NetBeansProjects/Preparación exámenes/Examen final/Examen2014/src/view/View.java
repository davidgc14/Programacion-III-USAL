package view;

import controller.Controller;

// import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.Esdia.*;

public class View {

    Controller c = new Controller();

    // Menús -------------------------------------------------------------

    public void runMenu(String menu) {

        String opcion;
        boolean salir = false;

        while(!salir) {

            opcion = readString(menu);

            switch(opcion.toLowerCase()) {
                case "1" -> this.menuLibros();
                case "2" -> this.menuRevistas();
                case "q" -> salir = true;
            }
        }

        System.out.println("Hasta luego!");
    }

    private void menuLibros() {
        
        String opcion = readString("MENU LIBROS%n"
                + "1. Añadir libro %n"
                + "2. Editar libro %n"
                + "3. Buscar libro %n"
                + "4. Eliminar libro %n"
                + "q. Volver %n"
                + "       >   ");

        boolean salir = false;

        while(!salir) {
            switch(opcion.toLowerCase()) {
                case "1" -> this.addLibro();
                case "2" -> this.editLibro();
                case "3" -> this.searchLibro();
                case "4" -> this.deleteLibro();
                case "q" -> salir = true;
            }
        }
    }

    private void menuRevistas() {

        String opcion = readString("MENU REVISTAS%n"
                + "1. Añadir revista%n"
                + "2. Buscar revista%n"
                + "3. Modificar revista%n"
                + "4. Eliminar revista%n"
                + "q. Volver%n"
                + "       >   ");

        boolean salir = false;

        while(!salir) {
            switch(opcion.toLowerCase()) {
                case "1" -> this.addRevista();
                case "2" -> this.searchRevista();
                case "3" -> this.editRevista();
                case "4" -> this.deleteRevista();
                case "q" -> salir = true;
            }
        }
    }
    
    // Libros -------------------------------------------------------------

    private void addLibro() {

    }
    
    private void editLibro() {

    }

    private void searchLibro() {

    }

    private void deleteLibro() {

    }

    // Revistas -------------------------------------------------------------

    private void addRevista() {

    }

    private void searchRevista() {

    }

    private void editRevista() {

    }

    private void deleteRevista() {

    }

}
