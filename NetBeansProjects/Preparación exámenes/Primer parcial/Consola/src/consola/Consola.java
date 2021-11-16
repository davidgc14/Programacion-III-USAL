package consola;

import java.io.Console;

public class Consola {
    public static void main(String[] args) {
        Console c = System.console(); // creación del ejemplar de console
	if (c != null) {
                // CONTRASEÑAS
		c.printf("Hola %s, escribe la contraseña : %n", System.getProperty("user.name"));
		char[] pswChar = c.readPassword();
                String pswString = new String(pswChar);
                c.printf("Su contraseña es - %s -%n", pswString);
                
                float n;
                c.printf("Introduzca un numero cualquiera por pantalla : ");
                n = Float.parseFloat(c.readLine());
                c.printf("%nEl numero introducido es %6.2f%n", n);
	} // end if
        else {
            System.err.println("No se pudo ejecutar Console");
        } // end else
    } // end of main
    
} // end of class