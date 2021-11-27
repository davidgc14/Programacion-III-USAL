package imbd21;

import view.View;

import static com.coti.tools.DiaUtil.*;

public class Main {
    public static void main(String[] args) {
        
        View v = new View();

        // comentado para poder ver mensajes de error por pantalla
        // clear();

        v.runMenu("%n1.- Archivos"
                + "%n2.- Peliculas"
                + "%n3.- Directores"
                + "%n4.- Actores"
                + "%n5.- Listados"
                + "%nq.- Cerrar Sesión"
                + "%n%n       >       ");
                
        System.out.printf("%n%nSALIENDO DEL PROGRAMA...%n%n");
        
        showFinalTime();

    } // end main

} // end class Main
