package strings;

import auxiliares.ImprimirCosas;
import auxiliares.Persona;

public class Strings {

    public static void main(String[] args) {
        
        ImprimirCosas imp = new ImprimirCosas();
        imp.imprimirMuchasCosas("Paco", "Perez");
        imp.imprimirMuchasCosas("Solo paco");
        
        Persona p1 = new Persona();
        
        String name = "Paco";
        p1.guardarNombre(name);
        p1.guardarEdad(23);
        
        Persona p2 = new Persona("Ana", 40);
        

        
        imp.imprimir(String.valueOf(p2.nombre));
        imp.imprimir(String.valueOf(p2.edad));
        
    }
    
    
    

    
}
