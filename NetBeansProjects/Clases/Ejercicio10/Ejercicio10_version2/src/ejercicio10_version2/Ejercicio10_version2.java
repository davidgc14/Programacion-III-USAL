package ejercicio10_version2;

/*
Este ejercicio está copiado del profesor. A mi personalmente no me gusta, porque el programa principal 
lo hace en función de los datos introducidos en el vector args, pero Datos está creado sólo para hacer media
con tres exámenes por alumno. 

Considere una mejora realizarlo en función del número de alumnos y de exámenes con los que realizar la media,
y el programa en general
*/

//importante importar la clase datos para poder usarla
import data.Datos;


// import com.coti.tools.Esdia.*;

public class Ejercicio10_version2 {
    
    public static void main(String[] args) {

        float[] notas = new float[args.length];
        // underline2("Calculo de nota media");
        System.out.println("Calculo de nota media a traves de LDO");

        // Longitud modulo tres congruente con cero. Supondremos que solo vamos a querer hacer media de 3 examenes
        if (args.length % 3 != 0) {
            System.err.printf("%nNumero de argumentos : %d%n", args.length);
            System.err.printf("%n%nFaltan datos. Saliendo del programa...%n");
            
            return;
        }
        
        /*
        Introducimos los valores en los vectores con los que vamos a trabajar
        */
        for (int i=0; i<args.length; i++) {
            notas[i] = Float.parseFloat(args[i]);
        }
        /*
        Al introducir los argumentos en args, java los splitea (hace la funcion split) para 
        separar los valores que hemos introducido nosotros en una sola linea
        */

        // Esto es una division de enteros. Hemos comprobado antes que args.length es modulo 3
        final int NUM_ALUMNOS = args.length / 3;
        
        // Ahora creamos ejemplares de Datos para cada alumno (en vector, aun no inicializado)
        Datos[] alumno = new Datos[NUM_ALUMNOS];
        // Cada elemento del vector alumno es cada alumno, el cual es un ejemplar de datos donde meteremos los valores de los examenes

        // ahora si inicializamos los ejemplares introduciendo los datos
        for (int i=0 ; i<NUM_ALUMNOS ; i++) {
            alumno[i] = new Datos(notas[3*i], notas[3*i + 1], notas[3*i + 2]);
            alumno[i].calcularMedia(); // entiendo que esto es para que la calcule y la deje almacenada en cada ejemplar
        }

        // Imprimimos por pantalla
        System.out.printf("|%6s|%6s|%6s|%6s|%n", "Nota1", "Nota2", "Nota3", "Media");
        // FOREACH String s:vector. Como ahora lo que recorremos son ejemplares, usamos el tipo de formato Dato
        for (Datos i:alumno) {
            System.out.println(i); 
            // System.out.println(i.toString());
            /* Esto segundo es lo que deberiamos poner, pero como en la clase Datos hay un 
            Ovewrite de toString, al intentar imprimir un ejemplar de la clase, Java invoca 
            toString() automaticamente
            */
        }

    } // end of main()

}// end of class
