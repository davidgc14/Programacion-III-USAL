package imbd21;

// DAVID GARCIA CURBELO
// Use este proyecto a fines formativos en la universidad 
// de Salamanca. No te copies porque te van a pillar. 
// No lo uses para nada malo.
// Si quieres colaborar conmigo, puedes contribuir por paypal a la cuenta asociada.

import view.View;

import static com.coti.tools.DiaUtil.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        View v = new View();

        clear();

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
