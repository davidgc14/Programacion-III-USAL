package solucioneccuadratica_archivo;


public class EcCuadratica {
    
    double a, b, c;

    // CONSTRUCTOR. mismo nombre que la clase
    
    public EcCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    // FACTORY
    
    // hacemos un factory para cada tipo posible de dato que pueda entrar
    
    public static EcCuadratica factory(String data) {
        // Va a entrar un string con los tres valores, y aqui 
        // los convetiremos y los devolveremos como numeros para
        // poder trabajar con ellos.
        
        
        // la variable que ha entrado la separamos en un vector
        // los datos de entrada serán de la forma "a    b   c"
        var separados = data.split("\t");
        
        if (3 != separados.length) {
            return null;
        }
        
        double tempA, tempB, tempC;
        
        // veamos si los podemos convertir en double
        try {
            tempA = Double.parseDouble(separados[0]);
            tempB = Double.parseDouble(separados[1]);
            tempC = Double.parseDouble(separados[2]);            
        } catch (Exception ex) {
            // en caso de que no se pueda convertir a double, es que 
            // algo hay mal, y por tnto no se devuelve nada
            return null;
        }
        
        // al usar el factory, nos ayuda a meter los datos en el constructor
        // de manera correcta
        return new EcCuadratica(tempA, tempB, tempC);
    }
    
    
    
    // este es una copia del anterior pero preparado para cadenas de string
    
    public static EcCuadratica factory(String[] data) {
        
        // rompe el programa si no son tres por linea
        if (3 != data.length) {
            return null;
        }
        
        double tempA, tempB, tempC;
        
        // rompe si no se pueden convertir en double
        try {
            tempA = Double.parseDouble(data[0]);
            tempB = Double.parseDouble(data[1]);
            tempC = Double.parseDouble(data[2]);            
        } catch (Exception ex) {
            return null;
        }
        
        // devuelve lo pedido si es todo correcto
        return new EcCuadratica(tempA, tempB, tempC);
    }
    
    
    
    // creamos un metodo para escribir en una sola linea la ecuacion completa
    
    public String toString(double a, double b, double c) {
        return String.format("%5.2fx² + %5.2fx + %5.2f = 0%n", a, b, c);
    }
    
    
    
    // este por si nos hiciera falta la imagen en un punto concreto
    
    double imagenEcuacionEn(double x) {
        return a*x*x + b*x + c;
    }
}

