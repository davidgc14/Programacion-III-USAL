import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class EscribirEnFichero {
    public static void main(String[] args) throws FileNotFoundException { // Ojo, que igual no se puede usar esa ruta
        // eso es lo que significa FileNot...
        PrintWriter pw;

        pw = new PrintWriter(new File("milnumeros.txt")); // Creamos y abrimos el fichero

        for(int i = 1; i <= 100; i++) {
            pw.printf("%d%n", i);
        }

        pw.close(); // cerramos el fichero
    }
}
