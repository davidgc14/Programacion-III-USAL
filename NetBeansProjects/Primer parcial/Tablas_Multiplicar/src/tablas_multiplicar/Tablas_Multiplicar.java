
// Usos de bucles for Anidados para la realizacion de tablas de multiplicar

package tablas_multiplicar;


import java.util.stream.IntStream;
import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.Esdia.*;
import static java.lang.System.out;

public class Tablas_Multiplicar {

    public static void main(String[] args) {
        underline2("Tablas de multiplicar con indices");
        
        for (int i = 1 ; i <= 10 ; i++){
            for (int j = 1 ; j <= 10 ; j++) {
                out.printf("%4d", i * j);
            }
            out.printf("%n");
        }
        
        
        
        underline2("Tablas de multiplicar sin indices V1.0");
        // version con lista de enteros creada a mano
        
        int [] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : numeros) {
            out.printf("%4d", i);
        }
        out.printf("%n");
        
        
        
        underline2("Tablas de multiplicar sin indices V2.0");
        
        for (int i : IntStream.rangeClosed(1, 10).toArray()) {
            for (int j : IntStream.range(1, 11).toArray()) { // Se pueden utilizar las dos versiones, intervalo abierto o cerrado
                out.printf("%4d", i*j);
            } // end for j
            out.printf("%n");
        }// end for i
        
        
        
        
        showFinalTime();
        
    } // end of main
    
} // end of class
