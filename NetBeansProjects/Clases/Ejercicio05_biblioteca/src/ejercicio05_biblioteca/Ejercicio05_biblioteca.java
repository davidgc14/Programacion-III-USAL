package ejercicio05_biblioteca;

import com.coti.tools.DiaUtil;
import static com.coti.tools.Esdia.readDouble;
import static com.coti.tools.Esdia.readFloat;

// import java.util.Scanner;

public class Ejercicio05_biblioteca {

    public static void main(String[] args) {
        float pesoA, pesoB, pesoC;
        double tallaA, tallaB, tallaC;
        // String temp = "";
        
        // Scanner sc = new Scanner(System.in);

        // leemos los pesos
    
        pesoA = readFloat("Cuanto pesa Tom ?  ");
        pesoB = readFloat("Cuanto pesa Dick ?  ");
        pesoC = readFloat("Cuanto pesa Harry ?  ");

        // leemos las alturas
    
        tallaA = readDouble("Cuanto mide Tom ?  ");
        tallaB = readDouble("Cuanto mide Dick ?  ");
        tallaC = readDouble("Cuanto mide Harry ?  ");
        
        
        // Calcular los máximos
        final float pesoMax = Math.max(Math.max(pesoA, pesoB), pesoC);
        final double tallaMax = Math.max(Math.max(tallaA, tallaB), tallaC);
   

        if (tallaA == tallaMax) {
            System.out.println("El más alto es Tom : " + tallaA);
        } else if (tallaB == tallaMax) {
            System.out.println("El más alto es Dick : " + tallaB);
        } else {
            System.out.println("El más alto es Harry : " + tallaC);
        } // end of if "alturas"


        if (pesoA == pesoMax) {
            System.out.println("El más pesado es Tom : " + pesoA);
        } else if (pesoB == pesoMax) {
            System.out.println("El más pesado es Dick : " + pesoB);
        } else {
            System.out.println("El más pesado es Harry : " + pesoC);
        } // end of if "pesos"


        DiaUtil.showFinalTime();
    } // end of main
    
} // end of class
