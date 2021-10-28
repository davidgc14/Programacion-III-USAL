import java.util.ArrayList;
import java.util.stream.IntStream;

public class foreach {
    public static void main(String[] args) {
        //////////////////////////
        // Ejemplo con un Array //
        //////////////////////////

        ArrayList<String> aList = new ArrayList<>();
        aList.add("Madrid");
        aList.add("Perú");
        aList.add("Pamplona");
        for (String n : aList) {
            System.out.println(n);
        }


        /////////////////////////
        // Ejemplo con numeros //
        /////////////////////////
        
        int min = 1, max = 10;
        int numeros[] = IntStream.rangeClosed(min, max).toArray(); // = {1,2,3,4,5,6,7,8,9,10};
        // Es importante transformarlo en un array, ya que si no el bucle no lo podrá recorrer
        // rangeClosed es para tomar intervalo cerrado

        for (int i : numeros) {
            for (int j : numeros) {
                System.out.printf("%4d", i*j);
            }
            System.out.println();
        }
    }
}
