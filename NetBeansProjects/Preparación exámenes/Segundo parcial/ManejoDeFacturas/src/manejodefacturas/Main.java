package manejodefacturas;

import view.View;
import static com.coti.tools.DiaUtil.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        clear();

        View v = new View();

        v.runMenu("%n1- Importar facturas de disco"
                + "%n2- Imprimir facturas seleccionadas"
                + "%nq- Salir"
                + "%n%n     >    ");
        
        showFinalTime();
        System.out.println("Fin del programa");
    }
    
}
