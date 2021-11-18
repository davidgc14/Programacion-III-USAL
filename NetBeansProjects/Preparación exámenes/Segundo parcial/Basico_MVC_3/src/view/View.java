package view;

import static com.coti.tools.Esdia.*;
// import static com.coti.tools.OpMat.*;
import com.coti.tools.Rutas;

import controller.Controller;

import java.io.File;


public class View {

    Controller c = new Controller();


    public void imprimir(String mensaje) {
        System.out.printf(mensaje + "%n%n");
    }
    

    public void runMenu(String menu) {

        boolean salir = false;

        String opcion;

        do {
            opcion = readString(menu);

            switch(opcion) {
                case "1" -> leerArchivo();
                case "2" -> imprimirDatos();
                case "q" -> salir = true;
                default  -> imprimir("Opción no válida");
            }
        } while(!salir);
    }// RUNMENU


    private void leerArchivo() {
        
        String nombreArch = readString("Indique nombre del archivo: ");
        
        imprimir("Leyendo el archivo...");

        File f = Rutas.fileToFileOnDesktop(nombreArch);

        String confirmacion;
        confirmacion = c.leerArchivo(f);

        if (confirmacion == null) {
            imprimir("Se ha importado correctamente");
        } else {
            imprimir(confirmacion);
        }

    }

    //ahora tengo que hablar con el modelo para que mande a imprimir,
    // porque es el unico que tiene informacion
    private void imprimirDatos() {
        imprimir("Imprimiendo datos...");
        c.imprimirDatos();
    }


} // END OF VIEW
