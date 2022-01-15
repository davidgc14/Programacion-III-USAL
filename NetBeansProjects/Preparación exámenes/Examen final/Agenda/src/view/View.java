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
                case "1" -> this.menuLista();
                case "2" -> this.anadirContacto();
                //case "3" -> this.buscarContacto();
                case "4" -> this.borrarContacto();
                case "q" -> {
                    salir = true;
                    this.guardadoDatos();
                }
                default -> System.out.println("Opción no válida");
            }
        } // edn while
    } // end runMenu


    private void guardadoDatos() {

        File f = Rutas.fileToFileOnDesktop("listado.txt");
        String mensaje = c.exportarContactos(f);
        
        if (mensaje != null) {
            System.out.printf(mensaje);
        } else {
            System.out.println("Datos guardados correctamente");
        }
    }

    private String importarContactos() {
        System.out.println("Importando contactos...");
        
        File f = Rutas.fileToFileOnDesktop("listado.txt");

        if (!f.exists()) {
            return "ERROR: Archivo no encontrado";
        } else {
            return c.importarContactos(f);
        }
    }

    private void menuLista() {
        String option = readString("%n   1.- por nombres"
                                    + "%n   2.- por apellidos"
                                    + "%n           >    ");
        
        switch(option) {
            case "1" -> this.listarContactosPorNombre();
            case "2" -> this.listarContactosPorApellido();
            default -> System.out.println("Opción no válida");
        }
    }

    private void listarContactosPorNombre() {
        System.out.println("Listado de contactos por nombre");
        System.out.println("--------------------------------");
        
        try {
            printToScreen3(c.listarContactosPorNombre());
        } catch (Exception ex) {
            System.out.println("Error al listar contactos");
        }
    }

    private void listarContactosPorApellido() {
        System.out.println("Listado de contactos por apellido");
        System.out.println("--------------------------------");
        
        try {
            printToScreen3(c.listarContactosPorApellido());
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
            System.out.println("Contacto añadido");
        } catch (Exception ex) {
            System.out.println("Error al añadir contacto");
        }
    }

    private void borrarContacto() {

        String borrar = readString("Indique el nombre y apellidos del contacto que desea borrar: ").trim();

        if(!c.verSiExiste(borrar)) {
            System.out.println("El contacto no existe");
        } else {
            System.out.println("Contacto borrado");
        }

    }
} // end class
