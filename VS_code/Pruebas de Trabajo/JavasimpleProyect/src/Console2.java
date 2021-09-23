import java.io.Console;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public class Console2 {
    public static void main(String[] args) {
        
        Console c = System.console(); // Obligatorio para abrir COnsole definir esta linea

        if (null != c) { // Si no estoy en la terminal de Netbeans, me devuelve null
            String nombre = System.getProperty("user.name"); // getProperty tiene acceso a datos de la computadora
            
            c.format("Bienvenido, %s %n%n", nombre); // format es llamar a un metodo de la clase
            // %s mete el nombre, las otras dos saltos de linea

            LocalDate fechaActual = LocalDate.now();

            int numeroDia = fechaActual.getDayOfMonth();
            int numeroMes = fechaActual.getMonthValue() - 1;

            // Lo que viene ahora es para que se guarde en formato de fecha espanol de espana

            Locale locale = new Locale("es", "ES");
            String[] nombresMeses = DateFormatSymbols.getInstance(locale).getMonths();
            String nombreMes = nombresMeses[numeroMes];


            // Ahora en trato con contrasenas

            // esto no es una cadena, es una lista de caracteres. y no son compatibles
            char[] pwdCharList = c.readPassword("%nPor favor, %s, Introduzca al contraseña: ", nombre);

            // paso de char a string
            String pwdString = new String(pwdCharList); 
            c.printf("%n%nSu contrasena es %s %n%n", pwdString);

            // impresion de dia y fecha
            c.printf("Fecha: %s de %s %n", numeroDia, nombreMes);


        } //else {
            //c.printf("La terminal no está abierta");
        //}

    }
}
