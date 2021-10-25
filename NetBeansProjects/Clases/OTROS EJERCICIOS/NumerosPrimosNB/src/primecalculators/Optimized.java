
package primecalculators;

import java.util.ArrayList;

public class Optimized {
            
    int lastNumber;
    
    // constructor
    public Optimized(int n) {
        this.lastNumber = n;
    }
    
    public boolean isPrime(int possiblePrimeNumber) {
        
        // Reducimos la busqueda solo a la raiz del numero de divisores
        long biggestPosibleDivisor = Math.round(Math.sqrt(possiblePrimeNumber));
        
        // empezamos en 3 porque 1,2,3 estan añadidos al array
        for (int divisor = 3 ; divisor < biggestPosibleDivisor ; divisor += 2) {
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
        // Se mantiene la busqueda de numeros impares
        for (int num = 5; num <= lastNumber; num+= 2) {
            if (isPrime(num)) {
                result.add(num);
            } // end if
        } // end for
        return result;
        
    } // End of listOfPrimeNumbers()

} // End of Class
