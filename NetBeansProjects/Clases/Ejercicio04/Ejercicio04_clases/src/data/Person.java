package data;

public class Person {
    
    // Estos son los atributos de cada persona
    
    
    private String name;
    private int age;
    private float height;
    
    
    /*
    El nombre de la función coincide con el nombre de la clase
    El metodo no devuelve nada
    El metodo se ejecuta automaticamente cuando se usa new
    
    Es lo que se conoce como un CONTSTRUCTOR
    
    El constructor no tiene tipo, es un error poner void
    
    El hecho de poner void o int, indica que el método devuelve algo
    */
    
    public Person(String nombre, int edad, float talla) {        
        /*
        this es una variable que se crea automáticamente en todas las clases
        this es un puntero que indica el ejemplar de Person en el que me encuentro
        
        */
        this.age = edad;
        this.height = talla;
        this.name = nombre;
    }
    
    /*
    Devuelve en forma de cadena los atributos de la clase
    
    Override está para sobreescribir un método ya existente
    */
    @Override
    public String toString() {
        return String.format("|%25s|%12d|%14.2f|", this.name, this.height, this.age);
    }
    
    
}
