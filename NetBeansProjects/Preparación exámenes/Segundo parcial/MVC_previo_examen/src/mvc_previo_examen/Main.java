package mvc_previo_examen;

import static com.coti.tools.DiaUtil.*;

import view.View;

public class Main {

    public static void main(String[] args) {

        View v = new View();
        
        clear();

        v.runMenu("%n1- Leer datos (automatizado)"
                + "%n2- Mostrar datos"
                + "%n3- Añadir usuario"
                + "%nq- Salir"
                + "%n%n    >    ");

        showFinalTime();
    }
    
}
