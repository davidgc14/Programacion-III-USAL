package lectura_datos_escritorio;

import com.coti.tools.OpMat;

import com.coti.tools.Rutas;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Lectura_datos_escritorio {

    public static void main(String[] args) {
        
        String[][] data;
        
        List<String> lista = new ArrayList<>();
        
        File f = Rutas.fileToFileOnDesktop("datos.txt");
        
        try {
            data = OpMat.importFromDisk(f,"\t");
        } catch (Exception ex) {
            System.out.println("Error, no se pudo leer");
            return;
        }
        
        for (String[] record : data) {
            lista.add(record);
        }
        
    }
    
}
