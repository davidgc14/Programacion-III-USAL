package data;

import static com.coti.tools.OpMat.importFromDisk;
import com.coti.tools.Rutas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;



public class Model {
    
    private List<Factura> facturasImportadas = null;
    private List<Factura> listaDeFacturasSolicitadas = null;
    private float importeMinimo;
    private final String nombreDelArchivoHTML = "archivo.html";
    
    public Model() {
        this.facturasImportadas = new ArrayList<>();
        this.listaDeFacturasSolicitadas = new ArrayList<>();
        
    }
    
    public void calcularListadoDeFacturasSolicitadas() {
        
        for (Factura f : facturasImportadas) {
            if (f.valorDeFactura() > this.importeMinimo) {
                listaDeFacturasSolicitadas.add(f);
            }
        }
    }
    
    public String[][] getTablaDeFacturas() {
        
        int numeroDeFacturas = this.listaDeFacturasSolicitadas.size();
        String[][] tdm = new String[numeroDeFacturas + 1][];
        tdm[0] = Factura.encabezado;
        
        for (int n=0; n < numeroDeFacturas; n++) {
            tdm[n + 1] = listaDeFacturasSolicitadas.get(n).datosDeFactura();
        }
        
        return tdm;
    }
    
    public String importarDatosDe(File f) {
        
        if (!f.exists()) {
            return String.format("%n%nPROBLEMA: %s no existe en el escritorio. Saliendo... %n%n",
                        f.toString()) + "%n%nCOPIE DATOS.TXT EN EL ESCRITORIO%n%n";
        }
        
        String[][] tmp;
        
        try {
            tmp = importFromDisk(f, "\t");
        } catch (Exception ex) {
            return "%n%nERROR: No fue posible importar el archivo";
        }
        
        
        for (String[] s : tmp) {
            Factura fac = Factura.factory(s);
            if (null != fac) {
                this.facturasImportadas.add(fac);
            }
        }
        
        // despues estudiaremos si el mensaje es vacio seguir, y si no pues mostrarlo por pantalla
        return "";
    }
    
    
    public String HTMLdeFacturas() {
        File f = Rutas.fileToFileOnDesktop(this.nombreDelArchivoHTML);
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.printf("<!DOCTYPE html>%n"
                    + "<HTML>%n"
                    + "<HEAD>$n"
                    + "<meta charset=\"UTF-8\">$n"
                    + "<H1>Listado de facturas superiores a %6.2f$</H1>%n"
                    + "</HEAD>%n"
                    + "<BODY>", this.importeMinimo);
            
            pw.printf("<TABLE BORDER=1>%n");
            pw.printf("%s%n", Factura.tableHeader(Factura.encabezado));
            
            for (Factura fac : listaDeFacturasSolicitadas) {
                pw.printf("%s%n", fac.comoFilaDeUnaTablaEnHTML());
            }
            
            pw.printf("</TABLE>%n</BODY>%n</HTML>%n");
            pw.close(); // hay que hacer esto obligatoriamente
            return "";
           
        } catch (FileNotFoundException ex) {
            return "ERROR: no se ha creado %s%n%n" + f.toString();
        }
    }
    
    // metodos de acceso necesarios
    
    public String getNombreDelArchivoHTML() {
        return this.nombreDelArchivoHTML;
    }
    
    public int getNumeroTotalDeFacturas() {
        return this.getNumeroTotalDeFacturas();
    }
    
    public float getImporteMinimo() {
        return this.importeMinimo;
    }
    
    public void setImporteMinimo(float importeMinimo) {
        this.importeMinimo = importeMinimo;
    }
    
}
