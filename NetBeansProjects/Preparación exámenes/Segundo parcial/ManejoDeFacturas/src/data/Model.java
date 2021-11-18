package data;

import java.io.File;
// import java.util.ArrayList;
import java.util.List;

import static com.coti.tools.OpMat.importFromDisk;

public class Model {
    
    private List<Factura> facturasGuardadas; 


    public void importarFacturasDe(File f) throws Exception {
        
        String[][] tmp = importFromDisk(f, "\t");

        for (String[] s : tmp) {
            Factura fac = Factura.factory(s); // s es un vector fila, con los elementos separados, cada uno se meterá en cada elemento del constructor
            this.facturasGuardadas.add(fac);
        }
    } // importar facturas


    public String[][] getTablaDeFacturas() {
        
        
        int numeroDeFacturas = this.facturasGuardadas.size();
        String[][] tmp = new String[numeroDeFacturas][];
        
        for (int i=0; i < numeroDeFacturas; i++) {
            tmp[i] = facturasGuardadas.get(i).datosFactura();
        }

        return tmp;
    }
}
