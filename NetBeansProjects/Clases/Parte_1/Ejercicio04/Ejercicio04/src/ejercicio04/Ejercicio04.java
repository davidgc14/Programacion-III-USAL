package ejercicio04;


/*
Tres usuarios introducen edad, nombre y talla. Hacer una tabla. (ANA, BOB, CARLOS)
*/
import java.io.Console;

public class Ejercicio04 {

    public static void main(String[] args) {
        
        // inicializamos datos
        String nombreAna, nombreBob, nombreCarlos;
        int edadAna, edadBob, edadCarlos;
        float alturaAna, alturaBob, alturaCarlos;
        
        // inisializamos ejemplar console
        Console c = System.console();
        
        // lectura de datos
        c.printf("Escriba el nombre de Ana: ");
        nombreAna = c.readLine();
        c.printf("Escriba el nombre de Bob: ");
        nombreBob = c.readLine();
        c.printf("Escriba el nombre de Carlos: ");
        nombreCarlos = c.readLine();
        
        // edades
        c.printf("Escriba edad de Ana: ");
        edadAna = Integer.parseInt(c.readLine());
        c.printf("Escriba edad de Bob: ");
        edadBob = Integer.parseInt(c.readLine());
        c.printf("Escriba edad de Carlos: ");
        edadCarlos = Integer.parseInt(c.readLine());
        
        // alturas
        c.printf("Escriba altura de Ana: ");
        alturaAna = Float.parseFloat(c.readLine());
        c.printf("Escriba altura de Bob: ");
        alturaBob = Float.parseFloat(c.readLine());
        c.printf("Escriba altura de Carlos: ");
        alturaCarlos = Float.parseFloat(c.readLine());

        
        //tabla
        c.printf("%n|%-15s|%-6s|%-7s|%n", "Nombre", "Edad", "Talla");
        
        c.printf("|%-15s|%-6d|%-7.2f|%n", nombreAna, edadAna, alturaAna);
        c.printf("|%15s|%6d|%7.2f|%n", nombreBob, edadBob, alturaBob);
        c.printf("|%15s|%6d|%7.2f|%n", nombreCarlos, edadCarlos, alturaCarlos);


    } // end of main()
    
} // edn of class
