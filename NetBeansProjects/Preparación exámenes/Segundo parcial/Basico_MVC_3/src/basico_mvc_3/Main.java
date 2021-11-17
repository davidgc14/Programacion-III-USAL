package basico_mvc_3;

import view.View;

import static com.coti.tools.DiaUtil.*;

public class Main {

    public static void main(String[] args) {

        View v = new View();

        clear();

        v.imprimir("Bienvenido a un nuevo ejemplo de MVC");
        // v.runMenu();

        showFinalTime();
    }
    
}
