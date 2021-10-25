/*
Construir un programa que calcule los numeros primos entre el 1 y un cierto valor dado
El caslculo debe haberse empleado diferentes algoritmos, y el programa
debe mostrar la cantidad de numeros primos obtenidos y el tiempo empleado en al ejecución
de cada algoritmo
*/

import primecalculators.*;

import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.Esdia.underline2;
import static java.lang.System.out;



public class Main {
    public static void main(String[] args) {
        // Declaracion de variables
        Good good = new Good(10000);
        Better better = new Better(10000);
        Optimized optimized = new Optimized(10000);


        underline2("%n%nGood");
        startTimerMS();
        startTimerNS();
        var temp = good.listOfPrimeNumbers();
        stopTimerAndPrintElapsedTimeMillis();
        stopTimerAndPrintElapsedTimeNanos();
        out.printf("%nCalculador Good: %d primos hallados%n%n%n", temp.size());
        // out.println(temp);
        temp.clear();

        underline2("Better");
        startTimerMS();
        startTimerNS();
        temp = better.listOfPrimeNumbers();
        stopTimerAndPrintElapsedTimeMillis();
        stopTimerAndPrintElapsedTimeNanos();
        out.printf("%nCalculador Better: %d primos hallados%n%n%n", temp.size());
        // out.println(temp);
        temp.clear();

        underline2("Optimized");
        startTimerMS();
        startTimerNS();
        temp = optimized.listOfPrimeNumbers();
        stopTimerAndPrintElapsedTimeMillis();
        stopTimerAndPrintElapsedTimeNanos();
        out.printf("%nCalculador Simple: %d primos hallados%n%n%n", temp.size());
        // out.println(temp);
        temp.clear();
        
        
        
        showFinalTime();
    } // end Main
    
} // end of Class
