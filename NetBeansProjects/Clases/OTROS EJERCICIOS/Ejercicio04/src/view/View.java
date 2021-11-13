package view;

import controller.Controller;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.printToScreen3;
import com.coti.tools.Rutas;

import java.io.File;
import static java.lang.System.out;

public class View {
    
    Controller c = new Controller();
    
    public void runMenu(String menu ) throws Exception {
        
        boolean salir = false;
        String option;
        
        do {
            option = readString(menu).toLowerCase();
            
            switch (option) {
                case "1" ->  this.importarFacturasDeDisco();
                case "2" ->  this.leerImporteMinimo();
                case "3" ->  this.calcularListadoDeMorosos();
                case "4" ->  this.imprimirFacturasAdeudadas();
                case "5" ->  this.crearHTMLdeFacturasAdeudadas();
                case "q" ->  salir = siOno("Desea salir del programa?");
                default  ->  out.printf("%n%nOpcion incorrecta");
            }
        } while(!salir);
    }
    
    // metodos de View propios de la implementacion
    
    private void importarFacturasDeDisco() {
        underline2("Lectura de datos (Archivo en el escritorio)");
        
        // Suponemos que el archivo está en el escritorio
        // y preguntamos el nombre al usuario (por ejemplo datos.txt)
        
        String archivo = readString_ne("Escriba el nombre del archivo: ");
        
        File rutaDelArchivo = Rutas.fileToFileOnDesktop(archivo);
        
        
        var mensajeDeError = c.importarDatosDe(rutaDelArchivo);
        
        if (mensajeDeError.isEmpty()) {
            out.printf("%n%nSe han importado %s facturas%n%n", mensajeDeError);
        } else {
            System.out.printf("Mensaje de error: archivo no encontrado. %nPruebe otra ruta u otro nombre%n%n");
        }
    }
    
    private void leerImporteMinimo() {
        
        underline2("Lectura del importe minimo");
        
        float tmp = readFloat("%n%nImporte minimo de las faturas deseadas: ");
        c.guardarImporteMinimoEnModelo(tmp);
        
        out.printf("%nImporte minimo = %8.2f $ %n%n", c.getImporteMinimo());
    }
        
    private void calcularListadoDeMorosos() {
        c.calcularLista();
        out.printf("%n%nCalculado el listado de facuras adeudadas%n%n");
    }
    
    private void imprimirFacturasAdeudadas() {
        
        underline2("Listado de facturas");
        
        try {                            // aqui se mira con lupa
            printToScreen3(c.getTablaDeFacturas());             
        } catch (Exception ex) {        // aqui se analiza si se encuentra alguna excepcion
            out.printf("%n%n----> No fue posible obtener listado de facturas%n%n");
        }
        
        // Exception ex para cualquier excepcion, todo lo raro, TODO
     
    }
    
    
    private void crearHTMLdeFacturasAdeudadas() throws Exception {
        
        // Este tiene trows exception, se avisa porque no hay nadie quien la capture 
        // Esto es porque no hemos usado dentro un try-catch

        underline2("Listado de facturas");
        
        c.generarArchivoHTML();
        int num = c.getNumeroDeFacturasSolicitadas();
        
        out.printf("%n%nSe ha creado una tabla con %d registros. %n%n", num);
        
        String nombre = c.getNombreArchivoHTML();
        out.printf("El archivo HTML se denomina %s%n", nombre);
              
    }
}
