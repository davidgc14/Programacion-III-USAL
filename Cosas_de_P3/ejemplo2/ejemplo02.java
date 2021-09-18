import java.io.Console;

public class ejemplo02 {
	public static void main(String[] args){
		// declaramos variables para 10 goles
		float g1, g2;

		Console c = System.console();
		c.printf("Goal Average%n%n");
		c.printf("Numero de goles del primer partido : ");
		g1 = Float.parseFloat(c.readLine());
		c.printf("Numero de goles del segundo partido : ");
		g2 = Float.parseFloat(c.readLine());
		// etc

		// Calculamos el Goalaverage
		float goalAverage = (g1+g2) ./ 2.0;

		c.printf("El goalaverage es %6.2f%n", goalAverage);
	}// end of main()
} // end of the class
