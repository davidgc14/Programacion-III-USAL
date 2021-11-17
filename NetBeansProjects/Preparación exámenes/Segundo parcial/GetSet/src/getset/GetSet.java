package getset;

public class GetSet {

    public static void main(String[] args) {
         
        Persona p = new Persona();

        p.setEdad(10);
        p.setNombre("Miguelito");

        System.out.printf("Tenemos al usuario %s con edad %d años%n", p.getNombre(), p.getEdad());
    }
    
}
