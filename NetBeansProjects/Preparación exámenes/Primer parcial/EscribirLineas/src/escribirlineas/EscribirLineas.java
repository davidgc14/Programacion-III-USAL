package escribirlineas;

import java.io.*;

public class EscribirLineas {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("archivo.txt");
		pw.printf("Mensaje para mis seguidores");
		pw.close();
	}
} // end class
