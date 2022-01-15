package agenda;

import view.View;

import static com.coti.tools.DiaUtil.*;

public class Main {


    public static void main(String[] args) {
        
        View v = new View();

        clear();

        v.runMenu("%n1.- Listar contactos"
                + "%n2.- Añadir contacto"
                + "%n3.- Buscar contacto"
                + "%n4.- Borrar contacto"
                + "%nq.- Cerrar Sesión"
                + "%n%n       >       ");
                
        System.out.printf("%n%nSALIENDO DEL PROGRAMA...%n%n");
        
        showFinalTime();
    }
    
}
