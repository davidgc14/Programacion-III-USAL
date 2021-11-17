package auxiliares;


public class Persona {
    
    public int edad;
    public String nombre;
    
    // CONSTRUCTOR
    
    public Persona(String name, int old) {
        this.nombre = name;
        this.edad = old;
    }

    public Persona() {
        this.nombre = "nada";
        this.edad = 1;

    }
    
    public void guardarNombre(String name) {
        this.nombre = name;
    }
    
    public void guardarEdad(int old) {
        this.edad = old;
    }
}
