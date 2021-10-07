import static com.coti.tools.Rutas.*;
import static com.coti.tools.OpMat.*;
import java.io.File;

public class LeerArchvio {
    
    public static void main(String[] args) throws Exception {
        
        File f = fileToFileOnDesktop("milnumeros.txt");

        double suma = sumColumn(importFromDisk(f, "\t", 0.0), 0); 
        
        // f: archivo del que leer
        // El segundo argumento es el posible separador que hay entre columnas (en este caso no hay pero lo ponemos por si acaso)
        // 0.0 para indicar que pueden ser decimales?
        // 0 para indicar que queremos sumar la primera columna
        // tambien se puede hacer como sigue

        // var tabla = impotFromDisk(f, "\t", 0.0);
        // double suma = sumColumn(tabla, 0); 


        System.out.printf("La suma de todos los numeros es %d", suma);

    }
}
