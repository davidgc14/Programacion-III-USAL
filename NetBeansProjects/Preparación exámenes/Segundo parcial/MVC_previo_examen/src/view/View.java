package view;

import controller.Controller;
import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;

import com.coti.tools.Rutas;
import java.io.File;


public class View {
    
    Controller c = new Controller();


    public void runMenu(String menu) {
        
        String option;
        
        this.leerDatos();
        boolean salir = false;

        do {
            
            option = readString(menu);

            switch (option) {
                case "1" -> System.out.printf("%nEsta función ya ha sido realizada%n%n");
                case "2" -> this.mostrarDatos();
                case "3" -> this.añadirUsuario();
                case "q" -> salir = true;
                default  -> System.out.println("Opción incorrecta");
            }
        } while (!salir);
    } // RUN MENU


    private String leerDatos() {

        System.out.printf("Importando archivo...%n%n");
        File f = Rutas.fileToFileOnDesktop("usuarios.txt");

        String datos = c.leerDatos(f);

        if(datos != "") {
            return datos;
        } else {
            return "Se han importado los datos con éxito";
        }
    }


    private void mostrarDatos() {

        System.out.printf("Mostrando datos...%n%n");
        
        try {
            printToScreen3(c.mostrarDatos());
        } catch (Exception ex) {
            System.out.println("No se han podido mostrar los datos");
        }
    }

    private void añadirUsuario() {

        String nombre, apellido1, apellido2;

        System.out.printf("Añadiendo usuario...%n%n");

        nombre = readString("Introduce el nombre           :  ");
        apellido1 = readString("Introduce el primer apellido  :  ");
        apellido2 = readString("Introduce el segundo apellido :  ");

        String intento = c.añadirUsuario(nombre, apellido1, apellido2);

        if(intento != "") {
            System.out.println(intento);
        } else {
            System.out.println("Usuario añadido con éxito");
        }
    }
}
