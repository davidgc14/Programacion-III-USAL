package solucioneccuadratica_archivo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.coti.tools.OpMat;
import com.coti.tools.Rutas;
import static com.coti.tools.DiaUtil.clear;

public class Main {

    
    public static void main(String[] args) {

        clear();

        File f = Rutas.fileToFileOnDesktop("ecuac.txt");

        String[][] data;
        try {
            data = OpMat.importFromDisk(f, "\t");
        } catch (Exception ex) {
            System.out.println("Error. No se pudo leer");
            return;
        }


        // esta será nuestra lista donde almacenaremos la variable movil
        // en ella cada elemento meteremos ejemplares de la ecuacion
        List<EcCuadratica> lista = new ArrayList<>(); 
        // esta va a ser nuestra variable movil
        EcCuadratica ec; 

        for (String[] corredor : data) {
            // almacenamos en el ejemplar del constructor la primera linea del archivo
            ec = EcCuadratica.factory(corredor);

            // si vemos el factory, en caso de que no se pueda almacenar, se devuelve null
            if (ec != null) {
                // metemos en nuestra lista de ejemplares cada uno de los correctos
                lista.add(ec);
            }
        }
        
        System.out.println(lista);
    } // end of Main
    
    
}
