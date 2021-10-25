package primecalculators;

// clase funcional pero no es optima ni de lejos

import java.util.ArrayList;

public class Good {
    
    int lastNumber;
    
    // constructor
    public Good(int n) {
        this.lastNumber = n;
    }
    
    public boolean isPrime(int possiblePrimeNumber) {
        for (int divisor = 2; divisor < possiblePrimeNumber; divisor++) {
            if (possiblePrimeNumber % divisor == 0) {
                return false;
            }
        }
        // si no hemos devuelto false con ningun numero entonces es primo
        return true;
    } // end of IsPrime()

    public ArrayList<Integer> listOfPrimeNumbers() {
        ArrayList<Integer> result = new ArrayList<>();
        // Añadimos los tres primeros primos
        result.add(1);
        result.add(2);
        result.add(3);
        
        // Comprobamos los primos y los metemos en la lista
        for (int num = 5; num <= lastNumber; num++) {
            if (isPrime(num)) {
                result.add(num);
            } // end if
        } // end for
        return result;
        
    } // End of listOfPrimeNumbers()
    
} // End of Class
