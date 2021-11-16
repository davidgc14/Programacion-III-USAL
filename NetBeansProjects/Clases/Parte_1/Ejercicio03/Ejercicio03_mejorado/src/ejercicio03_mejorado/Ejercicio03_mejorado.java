package ejercicio03_mejorado;

import java.io.Console;

public class Ejercicio03_mejorado {

    public static void main(String[] args) {
        // final indica que esta variable solo puede recibir valor una vez
        final int NUM_GOLES = 2;
        float[] g = new float[NUM_GOLES]; // g es una clase, y tiene metodos con g.---...
        Console c = System.console();
        
        // leemos los valores por pantalla
        c.printf("%ngoalaverage %n%n");
        for(int i=0; i<NUM_GOLES; i++) {
            c.printf("Escriba el numero de goles del partido %d: ", i+1);
            g[i] = Float.parseFloat(c.readLine()); // parseFloat convierte la entrada en float (si puede)
        }
        
        // Calculamos la media
        float goalAverage = 0.0f; // forzamos que el valor sea float
        for(int i=1; i < NUM_GOLES; i++) {
            goalAverage += g[i];
        }
        
        goalAverage /= NUM_GOLES;
        
        // Mostramos por pantalla la solución
        c.printf("El goal average es %f%n%n", goalAverage);
        
        
    } // end of main()
    
} // end of class ejercicio_mejorado
