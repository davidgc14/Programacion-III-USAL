package view;

/*
ESTA CLASE SOLO SE COMUNICA CON EL USUARIO

RECIBE INFORMACION, COMUNICA INFORMACION
*/



import controller.Controller; // esto hay que importarlo porque esta clase esta fuera del paquete actual
import static com.coti.tools.Esdia.*;
import static java.lang.System.out;

public class View {
    
    Controller c = new Controller(); // esto hay que ponerlo siempre
    
    public void runMenu(String menu) {
        // leer, calcular, mostrar, salir
        boolean salir = false;
        
        // La lectura por pantalla SIEMRPE ha de ser una cadena
        String opcion;
        
        do {
            opcion = readString(menu).toLowerCase();
            
            switch (opcion) {
                case "1" -> this.leerDatos();
                case "2" -> this.calcularResultados();
                case "3" -> this.mostrarResultados();
                case "q" -> salir = siOno("Desea salir de la aplicación?");
                default  -> System.out.printf("%n%nOpción Incorrecta%n%n");
            } // end of switch
        
        } while (!salir);
    } // end of runMenu
    
    
    private void leerDatos() {
        int num1 = readInt("%nEscriba un número     : ");
        int num2 = readInt("%nEscriba otro número   : ");
        out.println();
        
        c.storeIntoModel(num1, num2);
    } // end of leerDatos
    
    
    private void calcularResultados() {
        
        /*
        se pide al controlador que calcule los resultados
        El controlador contiene la logica del negocio
        */
        c.calculateResults();
        out.printf("Se ha calculado el resultado%n%n");
        
    } // end of calcularResultados
    
    
    private void mostrarResultados() {
        
        var num1 = c.getInfo_1();
        var num2 = c.getInfo_2();
        var result = c.getInfo_result();
        
        out.printf("%n%nLa suma de %d y %d es %d%n%n", num1, num2, result);
    } // end of mostrarResultados
    
} // End of View
