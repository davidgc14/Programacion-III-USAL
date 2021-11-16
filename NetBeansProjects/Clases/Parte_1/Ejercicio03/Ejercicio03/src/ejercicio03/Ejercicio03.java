package ejercicio03;

import java.io.Console;

public class Ejercicio03 {

    public static void main(String[] args) {
        float g1, g2, g3, g4, g5, media;
        Console c = System.console();
        
        c.printf("GOAL AVERAGE%n%n");
        
        c.printf("Datos de partido  1:");
        g1 = Float.parseFloat(c.readLine());
        c.printf("Datos de partido  2:");
        g2 = Float.parseFloat(c.readLine());
        c.printf("Datos de partido  3:");
        g3 = Float.parseFloat(c.readLine());
        c.printf("Datos de partido  4:");
        g4 = Float.parseFloat(c.readLine());
        c.printf("Datos de partido  5:");
        g5 = Float.parseFloat(c.readLine());
        
        // Calculo de la media
        media = (g1 + g2 + g3 + g4 + g5) / 5;
        
        // Imprimimos el resultado
        c.printf("El goalaverage es %f%n", media);
    } // End of main
    
} // End of class
