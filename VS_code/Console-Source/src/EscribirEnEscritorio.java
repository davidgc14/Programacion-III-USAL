import java.io.File;

public class EscribirEnEscritorio {
    
    public static void main(String[] args) {

        String ruta = System.getProperty("user.home") + // Guarda de manera correcta la dirección de la terminal
                        File.separator + // barra lateral en función del sistema operativo
                        "Desktop" + // Aniadimos la dirección que queramos
                        File.separator +
                        "photos_total.txt"; // Nombre del archivo para completar la ruta

        System.out.println("La ruta es " + ruta);
        
    } // end of main
} // end of class
