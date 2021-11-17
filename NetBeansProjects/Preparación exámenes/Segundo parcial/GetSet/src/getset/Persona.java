package getset;


public class Persona {
    
    // datos de los ejemplares
    private String nombre;
    private int edad;

    // CONSTRUCTOR
    public Persona() {
        this.nombre = "empty";
        this.edad = -1; 
    }

    public Persona(String name, int old) {
        this.nombre = name;
        this.edad = old;         
    }

    // GETTERS: PARA poder pedir la informacion al ejemplar
    // No modifica nada, solo proporciona informacion a otra clase
    public int getEdad() {
        return edad;
    }
    public String getNombre() {
        return nombre;
    }

    // SETTERS: para poder modificar datos del ejemplar
    // no devuelve nada, solo modifica el valor pedido y se va
    public void setEdad(int old) {
        this.edad = old;
    }
    public void setNombre(String name) {
        this.nombre = name;
    }

    

}
