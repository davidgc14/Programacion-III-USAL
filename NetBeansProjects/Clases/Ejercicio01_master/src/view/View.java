package view;

import static com.coti.tools.Esdia.*;
import static java.lang.System.out;

public class View {
    
    /*
    Introdución no MVC. Esto va a desaparecer
    En su lugar, se creará una clase Modelo desde la clase controlador;
    en la calse modelo residen los datos y resultados
    */
    
    public void runMenu(String menu) {
        // Leer, calcular, mostrar, salir
        
        // Por ahora estamos dentro, asi que no salimos
        boolean salir = false;
        
        // La lectura por pantalla SIEMRPE ha de ser una cadena
        String opcion;
        
        do {
            opcion = readString(menu);
            
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
        /*
        Esto no es MVC, esta informacion se el pasaría al controlador
        para que la guardase en el modelo
        */
        
        this.dato1 = num1;
        this.dato2 = num2;
    } // end of leerDatos
    
    
    private void calcularResultados() {
        /*
        Esto no es MVC, porque los datos
        */
        this.resultado = this.dato1 + this.dato2;
        System.out.printf("%n%nSe ha calculado el resultado%n%n");

    }
    
    private void mostrarResultados() {
        System.out.printf("%n%nLa suma de %d y %d es %d%n%n", this.dato1, this.dato2, this.resultado);
    }
}
