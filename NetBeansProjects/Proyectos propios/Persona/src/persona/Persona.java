package persona;


public class Persona {

    int edad;
    double peso;
    
    public void leerDatos() {
        System.out.println("Edad: " + edad);
        System.out.println("Peso: " + peso);
    } // metodo que se puede llamar cuando se quiera
    
    public int edadPorDos() {
        int x = 2*edad;
        return x; // Aquí si es necesario un return para devolver el doble
    }
    
    public static void main(String[] args) {
        Persona p = new Persona();
        p.edad = 20;
        p.peso = 65.4;
        
        p.leerDatos();
        
        System.out.println("Doble: " + p.edadPorDos());
        
    }
    
}
