package view;

import controller.Controller;

import static com.coti.tools.Esdia.*;
import com.coti.tools.Rutas;

import java.io.File;


public class View {
    
    Controller c = new Controller();

    public void runMenu(String menu) {
        
        String opcion;

        boolean salir;

        salir = this.openFiles("peliculas");
        if(!salir) {
            salir = this.openFiles("actores");
        }
        

        while(!salir) {
            
            opcion = readString(menu);

            switch(opcion) {
                case "1" -> this.menuPeliculas();
                case "2" -> this.menuActores();
                case "q" -> salir = this.save();
                default -> System.out.printf("Opción incorrecta%n%n");
            }
        }
    } // runMenu


    // Inicio y cierre de ficheros ---------------------------------------------------

    private boolean openFiles(String nombre) {
        File f = Rutas.fileToFileInFolderOnDesktop("IMBD21", nombre + ".bin");
        boolean salir = false;
        
        if (f.exists()) {
            System.out.println("Importando fichero binario de " + nombre + "...");
            String mensaje = c.importarArchivo(f);
            
            if (mensaje.isEmpty()) {
                System.out.println("Importación correcta del archivo " + f.getName());
            } else {
                System.out.println(mensaje);
            }
        } else {
            System.out.printf("ERROR: No se encuentra el fichero %s%n", f.getName());
            System.out.println("Importando fichero por defecto...");
            f = Rutas.fileToFileInFolderOnDesktop("IMBD21", nombre + ".txt");
            
            if (f.exists()) {
                String mensaje = c.importarArchivo(f);
                
                if (mensaje.isEmpty()) {
                    System.out.println("Importación correcta del archivo " + f.getName());
                } else {
                    System.out.println(mensaje);
                }
                
            } else {
                System.out.printf("ERROR: Tampoco se encuentra el fichero %s%n", f.getName());
                System.out.println("No se puede continuar");
                salir = true;
            }
        }
        System.out.println("------------------------------------------------------");
        return salir;
    }

    private boolean save() {

        return true;
    }


    // Menus -------------------------------------------------------------------------

    private void menuPeliculas() {

    }

    private void menuActores() {

    }



} // View
