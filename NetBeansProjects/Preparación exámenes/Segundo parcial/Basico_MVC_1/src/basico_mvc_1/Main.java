package basico_mvc_1;

// Ejercicio básico de MVC. Solo el uso de View. 
// Sumar dos numeros y mostrarlo mediante un menu.


import view.View;

import static com.coti.tools.DiaUtil.*;
// import static com.coti.tools.Esdia.*;


public class Main {

    public static void main(String[] args) {

        View v = new View();
        
        clear();

        v.mostrarMensaje("Bienvenido al sistema de gestion de tareas");

        v.runMenu("1- Leer datos%n" +
                "2- Calcular suma%n" +
                "3- Mostrar resultado%n" +
                "q- Salir%n" +
                "  -->  ");

        showFinalTime();

    }
    
}
