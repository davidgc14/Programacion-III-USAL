import static java.lang.System.out; // esto es para no tener que escribir System cuando queramos imprimir por pantalla

public class CreacionStr {
    
    public static void main(String[] args) {

        // creamos dos variables que hacen referencia al mismo espacio de memoria
        String s = "Hola";
        String q = s;
        out.println("s vale " + s);
        s = "mundo";
        out.printf("%n s ahora  vale "
                    + s
                    + " y /Hola/ no se ha descartado %n");
        out.printf("q sigue valiendo %s%n", q);

        // otro ejemplo: creamos un nuevo espacio de memoria para la nueva variable
        String t = "hola";
        String u = new String(t); // creamos un nuevo hueco de memoria, un clon
        out.printf("u vale igual que t: %s", u);

        
    }
}
