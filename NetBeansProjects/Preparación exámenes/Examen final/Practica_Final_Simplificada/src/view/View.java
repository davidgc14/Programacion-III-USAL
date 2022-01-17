package view;

import controller.Controller;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;

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
        String opcion;

        boolean salir = false;

        while(!salir) {

            opcion = readString("1.- Añadir película"
                    + "%n2.- Eliminar película"
                    + "%n3.- Modificar película"
                    + "%n4.- Buscar película"
                    + "%n5.- Listar películas"
                    + "%nq.- Salir"
                    + "%n      >     ");

            switch(opcion) {
                case "1" -> this.addPelicula();
                case "2" -> this.deletePelicula();
                case "3" -> this.modifyPelicula();
                case "4" -> this.searchPelicula();
                case "5" -> this.listPeliculas();
                case "q" -> salir = true;
                default -> System.out.printf("Opción incorrecta%n%n");
            }
        }
    }


    private void menuActores() {
        System.out.println("Aún no implementado");
        // unmantained
    }


    // Peliculas
    
    private void addPelicula() {
        System.out.println("AÑADIENDO PELICULA NUEVA");

        String titulo    = readString("Título     : ");
        String año       = readString("Año        : ");
        String duracion  = readString("Duración   : ");
        String pais      = readString("País       : ");
        String direccion = readString("Dirección  : ").replace(",", "\t");
        String guionista = readString("Guionista  : ");
        String musica    = readString("Música     : ");
        String reparto   = readString("Reparto    : ").replace(",", "\t");
        String productora= readString("Productora : ");
        String genero    = readString("Género     : ");
        String sinopsis  = readString("Sinopsis   : ");

        String[] datos = {titulo, año, duracion, pais, direccion, guionista, musica, reparto, productora, genero, sinopsis};
        
        
        String mensaje = c.addPelicula(datos);

        if (mensaje.isEmpty()) {
            System.out.println("Película añadida correctamente");
        } else {
            System.out.println(mensaje);
        }
    }

    private void deletePelicula() {

        String nombre = readString("Nombre de la película a eliminar: ");

        String mensaje = c.deletePelicula(nombre);

        if (mensaje.isEmpty()) {
            System.out.println("Película eliminada correctamente");
        } else {
            System.out.println(mensaje);
        }
    }

    private void modifyPelicula() {
        // unmantained
        System.out.println("MODIFICANDO PELÍCULA");
    }

    private void searchPelicula() {
        String nombre = readString("Nombre de la película a buscar: ");

        String mensaje = c.searchPelicula(nombre);

        if (mensaje.isEmpty()) {
            System.out.println("Película no encontrada");
        } else {
            System.out.printf(mensaje);
        }

    }

    private void listPeliculas() {
        underline2("LISTA COMPLETA DE PELICULAS");

        String[][] tmp = c.listarPeliculas();

        try {
            printToScreen3(tmp);
        } catch (Exception ex) {
            System.out.println("Error al imprimir peliculas");
        }
    }



} // View
