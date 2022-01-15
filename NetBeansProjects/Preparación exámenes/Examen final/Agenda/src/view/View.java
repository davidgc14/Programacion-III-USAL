package view;

import controller.Controller;
import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;

import java.io.File;

import com.coti.tools.Rutas;

public class View {
    
    Controller c = new Controller();

    
    public void runMenu(String menu) {

        String option;

        boolean salir = false;
        
        String mensaje = this.importarContactos();
        
        if (mensaje != null) {
            System.out.printf(mensaje);
            salir = true;
        } else {
            System.out.println("Importación de contactos correcta");
        }

        while(!salir) {
            option = readString(menu);

            switch(option.toLowerCase()) {
                case "1" -> this.listarContactos();
                case "2" -> this.anadirContacto();
                //case "3" -> this.buscarContacto();
                //case "4" -> this.borrarContacto();
                case "q" -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        } // edn while
    } // end runMenu


    private String importarContactos() {
        System.out.println("Importando contactos...");
        
        File f = Rutas.fileToFileOnDesktop("listado.txt");

        if (!f.exists()) {
            return "ERROR: Archivo no encontrado";
        } else {
            return c.importarContactos(f);
        }
    }

    private void listarContactos() {
        System.out.println("Listado de contactos");

        try {
            printToScreen3(c.listarContactos());
        } catch (Exception ex) {
            System.out.println("Error al listar contactos");
        }
    }

    private void anadirContacto() {
        System.out.println("Añadiendo contacto...");

        String nombre   = readString("Nombre   : ");
        String apellido = readString("Apellido : ");
        String numero   = readString("Número   : ");

        try {
            c.anadirContacto(nombre, apellido, Integer.parseInt(numero));
        } catch (Exception ex) {
            System.out.println("Error al añadir contacto");
        }

        System.out.println("Contacto añadido");
    }

} // end class
