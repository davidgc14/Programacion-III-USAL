package ejercicio05_scanner;

import java.util.Scanner;

public class Ejercicio05_Scanner {

    public static void main(String[] args) {
        float pesoA, pesoB, pesoC;
        double tallaA, tallaB, tallaC;
        // String temp = "";
        
        Scanner sc = new Scanner(System.in);

        // leemos los pesos
        
        System.out.printf("Cuanto pesa Tom ?  ");
        // temp = c.readLine();
        pesoA = sc.nextFloat();

        System.out.printf("Cuanto pesa Dick ?  ");
        // temp = c.readLine();
        pesoB = sc.nextFloat();

        System.out.printf("Cuanto pesa Harry ?  ");
        // temp = c.readLine();
        pesoC = sc.nextFloat();

        // leemos las alturas
        
        System.out.printf("Cuanto mide Tom ?  ");
        // temp = c.readLine();
        tallaA = sc.nextDouble();

        System.out.printf("Cuanto mide Dick ?  ");
        // temp = c.readLine();
        tallaB = sc.nextDouble();

        System.out.printf("Cuanto mide Harry ?  ");
        // temp = c.readLine();
        tallaC = sc.nextDouble();
        
        

        if (tallaA >= tallaB) {
            if (tallaA >= tallaC) {
                System.out.printf("El más alto es Tom : " + tallaA);
            } else {
                System.out.printf("El más alto es Harry : " + tallaC);
            }
        } else {
            if (tallaB >= tallaC) {
                System.out.printf("El más alto es Dick : " + tallaB);
            } else {
                System.out.printf("El más alto es Harry : " + tallaC);
            }
        } // end of if "alturas"
        
        
        
        if (pesoA >= pesoB && pesoA >= pesoC) {
            System.out.printf("El más pesado es Tom : " + pesoA);
        } else if (pesoB >= pesoA && pesoB >= pesoC) {
            System.out.printf("El más pesado es Dick : " + pesoB);
        } else {
            System.out.printf("El más pesado es Harry : " + pesoC);
        } // end of if "pesos"

    } // end of main
    
} // end of class
