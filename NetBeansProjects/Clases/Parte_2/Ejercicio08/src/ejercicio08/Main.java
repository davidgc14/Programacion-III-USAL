package ejercicio08;

import view.View;

import  static com.coti.tools.DiaUtil.*;

public class Main {


    public static void main(String[] args) {

        View v = new View();

        v.runMenu( "%n1.- Archivos"
                + "%n2.- Clasificacion"
                + "%n3.- Listados"
                + "%nq.- Salir"
                + "%n          >     ");

        showFinalTime();

    }
    
}
