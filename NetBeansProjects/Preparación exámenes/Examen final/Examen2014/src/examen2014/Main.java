package examen2014;

import view.View;

import static com.coti.tools.DiaUtil.*;

public class Main {

    public static void main(String[] args) {

        View v = new View();

        clear();

        v.runMenu("Elija una opción para comenzar: %n"
                + "1. Libros %n"
                + "2. Revistas %n"
                + "q. Salir %n"
                + "       >   ");

    }
    
}
