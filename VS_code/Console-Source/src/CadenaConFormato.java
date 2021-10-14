import java.util.Arrays;

public class CadenaConFormato {
    private static void CadenaConFormato() {
        String nombre = "John";
        int edad = 40;
        float altura = 1.89f;

        String COLUMNAS = String.format("%10s%4d%8.2f", 
                nombre,
                edad,
                altura);

        String formato = "%s\t%d\t%f";        

        String DELIMITADORES = String.format(formato, 
                nombre,
                edad,
                altura);

        System.out.println("En columnas : " + COLUMNAS);
        System.out.println("Con delimitadores : " + DELIMITADORES);
    }

    private static void CadenaConSeparador() {
        String s1 = "Hola";
        String s2 = "Mundo";
        String s3 = "!";

        String join = String.join("***", s1, s2, s3);
        System.out.println(join);


        // List<String> coleccion = Arrays.asList(s1, s2, s3);
        // String lista = String.join("-delimitador-", coleccion);
        // System.out.println(lista);
    }

    private static void traducir_A_String() {
        int edad = 33;
        float peso = 44.5f;
        boolean binomial = false;

        System.out.println();
        System.out.println(edad + 
                            " ocupa " +
                            String.valueOf(edad).length() +
                            " caracteres");
    }



    public static void main(String[] args) {
        traducir_A_String();
    }
}
