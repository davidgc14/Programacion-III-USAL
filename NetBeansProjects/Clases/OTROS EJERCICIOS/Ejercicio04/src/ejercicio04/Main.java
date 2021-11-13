package ejercicio04;


/*
Una compañia tiene un archivo de facturas, con formato de texto delimitado por tabuladores (CSV)

Cada linea del archivo contiene el nombre, apellidos, dni y telefono del cliente, asi 
como el importe de la factura, el tipo de IVA y el descuento aplicado ( que puede ser 0 
y se expresa como un numero menor que 1 y con dos decimales). 

Se pide construir un programa al que se le pueda proporcionar un valor minimo de factura, que se
calculara en la forma precio_base*IVA*(1-descuento) para cada factura, y que proporcione el listado
de clientes que tengan facturas con valor total mayor que el dado.

Resolver el problema usando colecciones y clases, incluso bibliotecas. Usar arquitectura MVC
*/







import view.View;
import static com.coti.tools.DiaUtil.showFinalTime;
import static java.lang.System.out;


public class Main {


    public static void main(String[] args) throws Exception {
        
        View v = new View();
        v.runMenu("%n1- Importar facturas en disco"
                + "%n2- Leer importe minimo"
                + "%n3- Calcular listado de facturas (IMPORTE > MINIMO)"
                + "%n4- Imporimir facturas seleccionadas"
                + "%n5- Crear HTML de facturas seleccionadas"
                + "%nq- Salir"
                + "%n%n   >  ");
        
        showFinalTime();
        out.println("Fin del programa%n");
    }
    
}
