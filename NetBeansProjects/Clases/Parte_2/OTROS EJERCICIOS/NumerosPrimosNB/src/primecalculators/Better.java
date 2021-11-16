package primecalculators;

// Considerable mejoria al reducir a la mitad la busqueda

import java.util.ArrayList;

public class Better {
        
    int lastNumber;
    
    // constructor
    public Better(int n) {
        this.lastNumber = n;
    }
    
    public boolean isPrime(int possiblePrimeNumber) {
        
        // Reducimos la busqueda solo a la mitad de los divisores
        final int upperLimit = possiblePrimeNumber / 2;
        
        for (int divisor = 2 ; divisor < upperLimit ; divisor ++) {
            if (possiblePrimeNumber % divisor == 0) {
                return false;
            } // end if
        } // end for
        
        return true;
        
    } // end of IsPrime()

    public ArrayList<Integer> listOfPrimeNumbers() {
        ArrayList<Integer> result = new ArrayList<>();
        // Añadimos los tres primeros primos
        result.add(1);
        result.add(2);
        result.add(3);
        
        // Comprobamos los primos y los metemos en la lista
        // MEJORA! solo vamos a comprobar los impares, luego solo la mitad de numeros
        // Pero ya el algoritmo solo comrpobaba la mitad de los divisores, luego 
        // el numero de calculos se divide entre 4
        for (int num = 5; num <= lastNumber; num+= 2) {
            if (isPrime(num)) {
                result.add(num);
            } // end if
        } // end for
        return result;
        
    } // End of listOfPrimeNumbers()

} // End of CLass
