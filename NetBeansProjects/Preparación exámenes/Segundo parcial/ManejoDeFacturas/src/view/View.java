package view;

import controller.Controller;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;

import com.coti.tools.Rutas;
import java.io.File;

// todos los throws Exception es porque no he querido poner el try catch ( y estamos tratando con lectura de archivos)

public class View {
    
    Controller c = new Controller();

    public void runMenu(String menu) throws Exception {

        boolean salir = false;
        String opcion;

        do {
            opcion = readString(menu);

            switch (opcion) {
                case "1" ->
                    this.importarFacturas();
                case "2" ->
                    this.imprimirFacturasSeleccionadas();
                case "q" ->
                    salir = true;
                default ->
                    System.out.println("Opción incorrecta");
            }

        } while(!salir);
    } // runMenu

    private void importarFacturas() throws Exception {
        underline2("Importando datos (archivo en el escritorio)");

        File rutaDelArchivo = Rutas.fileToFileOnDesktop("facturas.tsv");

        c.importarFacturasDe(rutaDelArchivo);

    }

    private void imprimirFacturasSeleccionadas() throws Exception {
        
        underline2("Listado de facturas");

        printToScreen3(c.getTablaDeFacturas());

    }

}
