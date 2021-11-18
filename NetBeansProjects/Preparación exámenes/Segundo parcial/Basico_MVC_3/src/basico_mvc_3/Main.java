package basico_mvc_3;

// clear y showfinaltime

import static com.coti.tools.DiaUtil.clear;
import static com.coti.tools.DiaUtil.showFinalTime;
import static com.coti.tools.Esdia.*;

import view.View;


public class Main {

    public static void main(String[] args) {

        View v = new View();

        clear();

        underline2("Bienvenido a un nuevo ejemplo de MVC");
        v.runMenu("%n1- Leer Datos del archivo"
                + "%n2- imprimir datos por pantalla"
                + "%nq- salir"
                + "%n   >   ");

        showFinalTime();
    }
    
}
