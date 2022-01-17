package practica_final_simplificada;


import view.View;

import static com.coti.tools.DiaUtil.*;


public class Main {

    public static void main(String[] args) {

        View v = new View();

        clear();

        v.runMenu("1.- PELICULAS"
                + "%n2.- ACTORES"
                + "%nq.- SALIR"
                + "%n      >     ");

        showFinalTime();
    }
    
}
