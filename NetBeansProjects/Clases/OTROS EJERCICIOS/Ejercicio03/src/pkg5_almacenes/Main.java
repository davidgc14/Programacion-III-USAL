package pkg5_almacenes;

/*
    Una compañia tiene cinco almacenes, cada uno de los cuales  vente dos 
    productos. Se dispone de una tabla para almacenar las ventas por unidades
    de los dos productos en todos los almacenes. Se dispone tambien de los precios
    que tiene cada unidad de los dos productos en todos los almacenes.

*/

/*
Calcular el importe total de ventas de la empresa. Pedir la informacion anterior por
teclado como resultado los datos en forma de tabla y el total de beneficios.
*/


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
