package view;

import controller.Controller;

// import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;

import java.io.File;

import com.coti.tools.Rutas;

public class View {

    Controller c = new Controller();

    // Menús -------------------------------------------------------------

    public void menuLibros(String menu) {

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
                case "1" -> this.addLibro();
                case "2" -> this.editLibro();
                case "3" -> this.searchLibro();
                case "4" -> this.deleteLibro();
                case "5" -> this.listaCompleta();
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

    
    // Libros -------------------------------------------------------------

    private void addLibro() {
        System.out.println("Añadir libro");
        String titulo =    readString("Título     : ");
        String autor =     readString("Autor      : ");
        String editorial = readString("Editorial  : ");
        int ano =             readInt("Año        : ");
        int isbn =            readInt("ISBN       : ");

        String[] datosLibro = {titulo, autor, editorial, Integer.toString(isbn), Integer.toString(ano)};
        c.addLibro(datosLibro);
    }
    
    private void editLibro() {
        System.out.println("Editar libro");
        
        String nombre = readString("Nombre del libro: ");

        int puestoEnLista = c.buscarLibro(nombre);

        if (puestoEnLista != -1) {
            String parametro = readString("¿Qué desea editar?\n"
                    + "1. Editorial\n"
                    + "2. Año\n"
                    + "3. ISBN\n"
                    + "    >  ");
            if (parametro.equals("1") || parametro.equals("2") || parametro.equals("3")) {
                String nuevoValor = readString("Nuevo valor: ");

                try {
                    c.editLibro(Integer.parseInt(parametro), puestoEnLista, nuevoValor);
                    System.out.println("Libro editado");
                } catch (Exception ex) {
                    System.out.println("Error al editar libro");
                }
            } else {
                System.out.println("Opción incorrecta");
            }
        } else {
            System.out.println("No se encontró el libro");
        }
    }

    private void searchLibro() {
        String nombre = readString("Nombre del libro: ");
        int puestoEnLista = c.buscarLibro(nombre);

        if (puestoEnLista != -1) {
            System.out.println("Libro encontrado");
            System.out.printf(c.imprimirLibro(puestoEnLista));
        } else {
            System.out.println("No se encontró el libro");
        }
    }

    private void deleteLibro() {
        String nombre = readString("Nombre del libro: ");
        int puestoEnLista = c.buscarLibro(nombre);

        if (puestoEnLista != -1) {
            String respuesta = readString("¿Está seguro de que desea eliminar el libro? (S/N) ").toLowerCase();

            if (respuesta.equals("s")) {
                c.deleteLibro(puestoEnLista);
                System.out.println("Libro eliminado");
            } else {
                System.out.println("Libro no eliminado");
            }
        } else {
            System.out.println("No se encontró el libro");
        }
    }

    private void listaCompleta() {
        System.out.println("Lista completa");

        try {
            String tmp[][] = c.listaCompleta();
            printToScreen3(tmp);
        } catch (Exception ex) {
            System.out.println("Error al imprimir lista");
        }
    }


}

