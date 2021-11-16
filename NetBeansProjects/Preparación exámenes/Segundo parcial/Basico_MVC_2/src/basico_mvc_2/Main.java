package basico_mvc_2;

// import static com.coti.tools.Esdia.*;
import static com.coti.tools.DiaUtil.*;

import view.View;

public class Main {

    public static void main(String[] args) {
        
        View v = new View();

        clear();

        v.imprimir("Bienvenido al MVC completo");

        v.runMenu(    "1. Pedir datos%n"
                    + "2. Calcular suma%n"
                    + "3. Mostrar resultado%n"
                    + "p. Salir%n"
                    + " -->   ");
        
        showFinalTime();
    }
    
}
