package ejemplo01;

import java.io.Console;

/**
 *
 * @author curbelo
 */
public class Ejemplo01 {

    public static void main(String[] args) {
     /**
     * @param args the command line arguments
     */
        String nombre, apellido1;
        
        // Vamos a declarar un ejemplar de Console
        Console c = System.console();
        
        System.out.printf("Escriba tu nombre         : ");
        nombre = c.readLine();
        System.out.printf("Escriba tu primer apellido : ");
        apellido1 = c.readLine();
        
        c.printf("Su nombre es %s %s", 
                nombre,
                apellido1);
        
        c.printf("La longitud de %s es : %d",nombre, nombre.length());
        // c.printf("La longitud de %s es : ", nombre.length());

    } // end of main()
    
} // end of class
