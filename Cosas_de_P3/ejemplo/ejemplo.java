import java.io.Console;

public class ejemplo {
	public static void main(String[] argumentos) {
		String nombre, apellido1;

		// declaramos una variable de tipo console para poder llamarla
		Console c = System.console();

		System.out.printf("Escriba su nombre       : ");
		nombre = c.readLine();
		System.out.printf("Escriba su primer apellido : ");
		apellido1 = c.readLine();
		// Se puede pedri el segundo apellido

		// Mostramos en pantalla los valores leidos
		c.printf("Su nombre es %s %s %n", 
			nombre,
			apellido1);
		c.printf("%nLongitud de %s : %d%n", nombre, nombre.length());
	}	
}
