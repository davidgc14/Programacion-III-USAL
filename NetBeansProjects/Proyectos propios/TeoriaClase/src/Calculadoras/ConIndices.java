package Calculadoras;

public class ConIndices {
    int suma;
    int ultimoNumero;
    
    // COnstructor, para los datos del Main
    public ConIndices(int n) {
        suma = 0;
        ultimoNumero = n;
    }
    
    public void calcularSuma(){
        for (int i = 1; i <= ultimoNumero ; i ++) {
            suma += i;
        }
    }
    
    public void mostrarResultado() {
        System.out.printf("La suma de los %d primeros numeros es %d%n%n", ultimoNumero, suma);
    }

}

