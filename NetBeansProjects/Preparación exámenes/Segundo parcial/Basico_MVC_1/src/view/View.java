package view;

// import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.Esdia.*;

public class View {

    int valor1, valor2, resultado;
    
    public void mostrarMensaje(String mensaje){
        System.out.printf(mensaje + "%n%n");
    }
    
    public void runMenu(String menu) {
        boolean salir = false;

        String opcion_elegida;

        do {
            opcion_elegida = readString(menu);


            // ponemos this porque estos metodos se encuentran en la clase View
            switch (opcion_elegida) {
                case "1" ->
                    this.leerDatos();
                case "2"->
                    this.sumarDatos();
                case "3"->
                    this.mostrarDatos();
                case "q"->
                    salir = true;
                default -> 
                    this.mostrarMensaje("Opción no válida");
            } // end of switch
        } while (!salir);
    }

    // estos metodos han de ser privados ya que solo pueden ser accedidos desde la clase View
    private void leerDatos() {
        valor1 = readInt("Introduce el primer valor ");
        valor2 = readInt("Introduce el segundo valor ");
    }

    private void sumarDatos() {
        resultado = valor1 + valor2;
        this.mostrarMensaje("Los valores han sido sumados");
    }

    private void mostrarDatos() {
        this.mostrarMensaje("El resultado es: " + valor1 + " + " + valor2 + " = " + resultado);
    }
    
}
