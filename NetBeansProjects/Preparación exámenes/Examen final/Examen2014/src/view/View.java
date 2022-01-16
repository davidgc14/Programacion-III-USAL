package view;

import controller.Controller;

// import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.Esdia.*;

import java.io.File;

import com.coti.tools.Rutas;

public class View {

    Controller c = new Controller();

    // Menús -------------------------------------------------------------

    public void runMenu(String menu) {

        String opcion;
        boolean salir = false;


        String error = this.importarDatos();

        if (error != null) {
            System.out.println(error);
            salir = true;
        } else {
            System.out.println("Importación correcta");
        }

        while(!salir) {

            opcion = readString(menu);

            switch(opcion.toLowerCase()) {
                case "1" -> this.menuLibros();
                case "2" -> this.menuRevistas();
                case "q" -> {
                    salir = true;
                    if(c.salirYguardar() != null) {
                        System.out.println(c.salirYguardar());
                    } else {
                        System.out.println("Guardado correcto");
                    }
                }
            }
        }
        System.out.println("Hasta luego!");
    }


    private String importarDatos() {

        String error = null;
    
        File f = Rutas.fileToFileOnDesktop("libros.bin");

        if (f.exists()) {
            System.out.println("Archivo binario encontrado");
            error = c.importarDatos(f);
            if (error != null) {
                System.out.println("Intentamos importar desde texto");
                f = Rutas.fileToFileOnDesktop("libros.txt");
            
                if (f.exists()) {
                    System.out.println("Archivo txt encontrado");
                    error = c.importarDatos(f);
                } else {
                    error = "No se encontró ningún archivo de datos";
                }    
            }
        } else {
            System.out.println("Archivo binario no encontrado");
            
            f = Rutas.fileToFileOnDesktop("libros.txt");
            
            if (f.exists()) {
                System.out.println("Archivo txt encontrado");
                error = c.importarDatos(f);
            } else {
                error = "No se encontró ningún archivo de datos";
            }
        }
        return error;
    }


    // Menús de libros -------------------------------------------------------------

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

        System.out.println("MENU SIN USO");
        String opcion = "";
        /*
        String opcion = readString("MENU REVISTAS%n"
                + "1. Añadir revista%n"
                + "2. Buscar revista%n"
                + "3. Modificar revista%n"
                + "4. Eliminar revista%n"
                + "q. Volver%n"
                + "       >   ");
        */

        boolean salir = true;

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
