package sumar2numeros_mvc;


import static com.coti.tools.DiaUtil.clear;
import static com.coti.tools.DiaUtil.showFinalTime;
import static com.coti.tools.Esdia.underline2;
import view.View;

public class Main {

    public static void main(String[] args) {
        
        clear();
        underline2("Lectura de dos números");
        
        // View es la clase que se comunica con el usuario
        
        View v = new View();
        v.runMenu("1.- Leer dos números%n"
                    + "2.- Calcular suma%n"
                    + "3.- Mostrar resultado%n"
                    + "q.- Salir%n"
                    + "  > ");
        showFinalTime();
    } // end of main();
    
}
