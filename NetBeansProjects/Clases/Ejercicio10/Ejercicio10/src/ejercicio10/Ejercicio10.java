package ejercicio10;

/*
Ejercicio para el uso de la linea de ordenes
*/

public class Ejercicio10 {

    // funcion sumatoria de un vector
    public static float suma(float[] vector) {
        float suma = 0.0f;
        for (int i=0 ; i<vector.length ; i++) {
            suma += vector[i];
        }

        return suma;
    } // end of suma


    public static void main(String[] args) {
        final int NumeroAlumnos = 3;
        final int NumeroParciales = 3;
        
        float[][] notas = new float[NumeroAlumnos][NumeroParciales];
        float[] media = new float[NumeroAlumnos];
        

        // comprobación de que la cantidad de datos entrados coincide con el numero de variables
        
        /* args es el total de variables no asignadas que asignaremos desde NetBeans
        Boton derecho sobre el proyecto. Propiedades. Run. Arguments. 
        Introducimos los valores con los que queremos que el probrama trabaje 
        Para que no tengan que ser pedidos desde la terminal
        
        Dichos valores se guardan en el vector por defecto args[]. Se pueden pedir en cualquier momento.
        */
        if (args.length != NumeroAlumnos*NumeroParciales) {
            System.err.printf("%nNumero de argumentos : %d%n", args.length);
            System.err.printf("%n%nFaltan datos. Saliendo del programa...%n");
            return;
        }
        
        /*
        Introducimos los valores en los vectores con los que vamos a trabajar
        */
        int contador = 0;
        for (int i=0; i<NumeroAlumnos; i++) {
            for (int j=0; j<NumeroParciales; j++) {
                notas[i][j] = Float.parseFloat(args[contador]);
                contador++;
            }
        }
        /*
        Al introducir los argumentos en args, java los splitea (hace la funcion split) para 
        separar los valores que hemos introducido nosotros en una sola linea
        */

        // calculamos ahora la media
        System.out.println();

        for (int i=0 ; i<NumeroAlumnos ; i++) {
            media[i] = suma(notas[i]) / NumeroParciales;
            System.out.printf("Media del alumno %d : %4.2f%n%n", i+1, media[i]);
        }
        // la division entre float y int da como resultado un float

    } // end of main()

}// end of Class
