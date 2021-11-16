package view;

import static com.coti.tools.Esdia.*;
// import static com.coti.tools.DiaUtil.*;

import controller.Controller;

public class View {
    
    Controller c = new Controller();

    public void imprimir(String mensaje) {
        System.out.printf(mensaje + "%n%n");
    }

    public void runMenu(String menu) {
        
        boolean salir = false;

        do {

            String opcion_elegida = readString(menu);

            switch(opcion_elegida) {
                case "1"
                    -> this.leerDatos();
                case "2"
                    -> this.calcularSuma();
                case "3"
                    -> this.mostrarResultado();
                case "q"
                    -> {
                        salir = true;
                        this.imprimir("Que tenga buen día");
                    }
                default 
                    -> this.imprimir("Opción no válida");

            }// end switch
        } while(!salir); // end do-while
        
        
    }// END OF RUNMENU

    private void leerDatos() {
        int num1 = readInt("Introduzca el primer numero ");
        int num2 = readInt("Introduzca el segundo numero ");

        c.almacenarDatos(num1, num2);
    }

    private void calcularSuma() {
        c.sumarDatos();
        imprimir("La suma ha sido calculada");
    }

    private void mostrarResultado() {
        int var1, var2, result;

        var1 = c.getInfo1();
        var2 = c.getInfo2();
        result = c.getResult();

        imprimir(var1 + " + " + var2 + " = " + result);
    }
}
