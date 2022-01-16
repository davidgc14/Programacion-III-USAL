package examen2014;

import view.View;

import static com.coti.tools.DiaUtil.*;

public class Main {

    public static void main(String[] args) {

        View v = new View();

        clear();

        v.menuLibros("MENU LIBROS%n"
                + "1. Añadir libro %n"
                + "2. Editar libro %n"
                + "3. Buscar libro %n"
                + "4. Eliminar libro %n"
                + "5. Lista completa %n"
                + "q. Volver %n"
                + "       >   ");
        
        showFinalTime();

    }
    
}
