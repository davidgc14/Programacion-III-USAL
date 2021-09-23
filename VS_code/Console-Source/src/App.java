// import static System.err.*;
// import static System.out.*;

public class App {
    public static void main(String[] args) {
        // supuestamente no sería necesario usar System
        System.out.printf("Normal%n"); // Se pone esta orden en la cola de procesos
        System.err.printf("Error%n"); // Interrumpe cualquier proceso y prioriza la impresion del mensaje

        // Pero VSCode no tiene colores en terminal, solo NetBeans
    }
}
