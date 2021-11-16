package ejercicio04_clases;

import static com.coti.tools.Esdia.readFloat;
import static com.coti.tools.Esdia.readInt;
import data.Person; // Metemos la clase creada anteriormente para poder acceder a ella
import java.util.ArrayList;


public class Ejercicio04_clases {

    public static void main(String[] args) {
        
        // Es equivalente cualquiera de los dos siguientes
        // List<Person> personas = new ArrayList<Person>();
        var personas = new ArrayList<Person>();
        String [] listaNombres = {"Eany", "Meany", "Moe"};
        
        // lectura de datos
        
        Person p;
        
        System.out.printf("%nEany, Meany, Moe%n%n");
        
        for(String nombre : listaNombres) {
            int edad = readInt(String.format("%-25s : ","Escriba la edad de " + nombre));
            float altura = readFloat(String.format("%-25s : ","Escriba la altura de " + nombre));
            p = new Person(nombre, edad, altura);
            
            personas.add(p);
            System.out.println("");
        } // end for
        
        
        // creamos correctamente la tabla, lo podemos hacer de varias formas
        
        //no optima: System.out.printf("%nEany, Meany, Moe%n%n");
        var tmp = String.join(", ", listaNombres);
        System.out.println("tmp");
        // System.out.println("String.join(", ", listaNombres)");
        
        
        // encabezado de la tabla: 
        System.out.printf("%n|%-25s|%-12s|%-14s|%n", 
                            "Nombre", 
                            "Edad",
                            "Talla");
        
        // Version larga, facil de entender
        
        for (int n = 0; n < personas.size(); n++) {  // size se usa para colecciones, length es para variables sueltas
            System.out.printf("|%-25s|%-12d|%-14.2f|%n",
                    personas.get(n).getName(),
                    personas.get(n).getAge(),
                    personas.get(n).getHeight());
        } // end for
        
        // Version intermedia
        
        System.out.println("");
        for (Person per : personas) {  
            System.out.printf("|%-25s|%-12d|%-14.2f|%n",
                    per.getName(),
                    per.getAge(),
                    per.getHeight());
        } // end for
        
        
        // Version pro
        System.out.println("");
        System.out.println(String.join(", ", listaNombres));
        System.out.printf("%n|%-25s|%-12s|%-14s|%n", 
                    "Nombre", 
                    "Edad",
                    "Talla");
        for (Person per : personas) {
            System.out.println(per);
        }

        
    } // end of main
    
} // end of class
