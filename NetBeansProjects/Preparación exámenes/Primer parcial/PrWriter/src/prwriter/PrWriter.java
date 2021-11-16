package prwriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class PrWriter {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("texto.txt");
        pw.println("Texto");
        pw.close();
    }
    
}
