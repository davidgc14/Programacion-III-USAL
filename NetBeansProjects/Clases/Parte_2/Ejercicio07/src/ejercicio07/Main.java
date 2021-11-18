package ejercicio07;

import view.View;


public class Main {

    public static void main(String[] args) {
        
        View v = new View();

        v.runMenu("1- Importar lista general%n"
                + "2- Mostrar lista general%n"
                + "3- Mostrar tabla de alumnos con baja asistencia%n"
                + "4- Ordenar la lista general de apellidos y nombre%n"
                + "5- Exportar lista general de alumnos%n"
                + "6- Exportar lista de alumnos con asistencia%n"
                + "7- salir");
    }
    
}
