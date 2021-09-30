package ejercicio05;

import java.io.Console;

public class Ejercicio05 {

    public static void main(String[] args) {
        float pesoA, pesoB, pesoC;
        double tallaA, tallaB, tallaC;
        String temp = "";
        
        Console c = System.console();

        // leemos los pesos
        
        c.printf("Cuanto pesa Tom ?  ");
        temp = c.readLine();
        pesoA = Float.parseFloat(temp);

        c.printf("Cuanto pesa Dick ?  ");
        temp = c.readLine();
        pesoB = Float.parseFloat(temp);

        c.printf("Cuanto pesa Harry ?  ");
        temp = c.readLine();
        pesoC = Float.parseFloat(temp);

        // leemos las alturas
        
        c.printf("Cuanto mide Tom ?  ");
        temp = c.readLine();
        tallaA = Double.parseDouble(temp);

        c.printf("Cuanto mide Dick ?  ");
        temp = c.readLine();
        tallaB = Double.parseDouble(temp);

        c.printf("Cuanto mide Harry ?  ");
        temp = c.readLine();
        tallaC = Double.parseDouble(temp);

        if (tallaA >= tallaB) {
            if (tallaA >= tallaC) {
                c.printf("El más alto es Tom : %6.2f %n", tallaA);
            } else {
                c.printf("El más alto es Harry : %6.2f %n", tallaC);
            }
        } else {
            if (tallaB >= tallaC) {
                c.printf("El más alto es Dick : %6.2f %n", tallaB);
            } else {
                c.printf("El más alto es Harry : %6.2f %n", tallaC);
            }
        } // end of if

    } // end of main
    
} // end of class
