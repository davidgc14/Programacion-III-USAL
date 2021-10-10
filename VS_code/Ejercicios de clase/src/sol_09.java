import static com.coti.tools.Esdia.*; // Esto es para la lectura de datos directa readInt, ...
import static com.coti.tools.DiaUtil.*;

public class sol_09 {
    public static void main(String[] args) {
        final int NumAlumnos = 3;
        final int NumParciales = 3;
        
        float notas[][] = new float[NumAlumnos][NumParciales];
        float medias[] = new float[NumAlumnos];
        
        float auxSuma = 0;

        clear();
        
        // Lectura de notas de los alumnos
        for (int i=0; i<NumAlumnos; i++) {
            for (int j=0; j<NumParciales; j++) {
                
                System.out.printf("Nota del alumno %d, Parcial %d : ", i+1, j+1);
                notas[i][j] = readFloat("");
                auxSuma += notas[i][j];
            } // end for j

            // Cálculo de la media
            medias[i] = auxSuma / (NumParciales * 1.0f);
            auxSuma = 0;
        }// end for i


        System.out.printf("%n Datos introducidos : %n%n");

        // Construimos el encabezado de la tabla
        System.out.printf("         ");
        for (int j=0; j<NumParciales; j++) {
            System.out.printf("Parcial%d ", j+1);
        }   
        System.out.printf("Medias%n");


        // Construimos el resto de al tabla
        for (int i=0; i<NumAlumnos; i++) {
            System.out.printf("Alumno%d |", i+1);

            for (int j=0; j<NumParciales; j++) {
                System.out.printf("%8.2f|", notas[i][j]);
            } // end for j

            System.out.printf("%8.2f%n", medias[i]);
        }// end for i


    } // end of main
}// end of class
