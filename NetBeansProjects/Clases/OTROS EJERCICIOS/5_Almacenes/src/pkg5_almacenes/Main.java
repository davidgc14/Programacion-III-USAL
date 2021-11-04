package pkg5_almacenes;

import static com.coti.tools.DiaUtil.*;

import view.View;

public class Main {

    public static void main(String[] args) {

        clear();
        
        View v = new View();
        
        v.runMenu("1.- Leer tabla de ventas%n"
                + "2.- Leer tabla de precios%n"
                + "3.- Calcular ingresos%n"
                + "4.- Mostrar resultados%n"
                + "q.- Salir%n"
                + "   >  ");
        
        showFinalTime();
    } // End of main
    
    
}
