package data;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Factura {
    
    private float descuento;
    private float importe;
    private float tipoDeIVA;
    private String concepto;
    private String fecha;
    private String NIF;
    private String nombre;
    private String direccion;
    protected final static String[] encabezado = 
        {"Concepto", "Descuento", "Fecha", "Valor", "NIF", "Nombre", "Dirección", "IVA"};
    
    
    // Cosntructor por defecto de la clase Factura
    public Factura(String concepto, float descuento, String fecha, float importe, String NIF, String nombre, String razon_social, float tipo_de_IVA) {
        this.importe = importe;
        this.descuento = descuento;
        this.tipoDeIVA = tipo_de_IVA;
        this.concepto = concepto;
        this.fecha = fecha;
        this.NIF = NIF;
        this.nombre = nombre;
        this.direccion = razon_social;
    }

    // constructor auxiliar para la clase Factura
    public Factura() {
        this.importe = 0;
        this.descuento = 0;
        this.tipoDeIVA = 0;
        this.concepto = "DESCONOCIDO";
        this.fecha = "DESCONOCIDO";
        this.NIF = "DESCONOCIDO";
        this.nombre = "DESCONOCIDO";
        this.direccion = "DESCONOCIDO";
    }
    
    public String[] datosDeFactura() {
        String tmp_descuento = String.format("%2.2f", this.descuento);
        String tmp_valor_factura = String.format("%2.2f", this.valorDeFactura());
        String tmp_tipo_de_IVA = String.format("%2.2f", this.tipoDeIVA);
        String[] rd = {
            this.concepto, 
            tmp_descuento, 
            this.fecha, 
            tmp_valor_factura, 
            this.NIF, 
            this.nombre, 
            this.direccion, 
            tmp_tipo_de_IVA};
        return rd;
    }

    public String comoFilaDeUnaTablaEnHTML() {
        String resultado;
        resultado = String.format(
                "<tr>"
                + "<td>%s</td>"
                + "<td>%s</td>"
                + "<td>%s</td>"
                + "<td>%s</td>"
                + "<td>%s</td>"
                + "<td>%s</td>"
                + "<td>%s</td>"
                + "<td>%s</td>"
                + "</tr>",
                this.concepto,
                this.descuento,
                this.fecha,
                this.importe,
                this.NIF,
                this.nombre,
                this.direccion,
                this.tipoDeIVA);

        return resultado;
    }

    protected static String tableHeader(String[] datos) {
        String resultado;
        resultado = String.format(
                "<tr>"
                + "<th>%s</th>"
                + "<th>%s</th>"
                + "<th>%s</th>"
                + "<th>%s</th>"
                + "<th>%s</th>"
                + "<th>%s</th>"
                + "<th>%s</th>"
                + "<th>%s</th>"
                + "</tr>",
                datos[0],
                datos[1],
                datos[2],
                datos[3],
                datos[4],
                datos[5],
                datos[6],
                datos[7]);
        return resultado;
    }

    public static Factura factory(String[] tokens) {
        if (8 != tokens.length) {
            return null;
        }
        Factura fac = new Factura();
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);

        // el locale espera comas, luego cambiamos el punto por la coma

        tokens[1] = tokens[1].replace('.', ',');
        tokens[3] = tokens[3].replace('.', ',');
        tokens[7] = tokens[7].replace('.', ',');

        try {
            fac.concepto = tokens[0];
            fac.descuento = nf.parse(tokens[1]).floatValue();
            fac.fecha = tokens[2];
            fac.importe = nf.parse(tokens[3]).floatValue();
            fac.NIF = tokens[4];
            fac.nombre = tokens[5];
            fac.direccion = tokens[6];
            fac.tipoDeIVA = nf.parse(tokens[7]).floatValue();
            return fac;
        } catch (ParseException ex) {
            return null;
        }
    }

    public static Factura factory(String linea) {
        // String[] tokens = linea.split(";");
        // return Factura.factory(tokens);
        return Factura.factory(linea.split("\t"));
    }

    float valorDeFactura() {
        return this.importe * (1.0f - this.descuento / 100.0f) * (1.0f + this.tipoDeIVA);
    }


    // Metodos de acceso

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getTipoDeIVA() {
        return tipoDeIVA;
    }

    public void setTipoDeIVA(float tipoDeIVA) {
        this.tipoDeIVA = tipoDeIVA;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

} // Fin de la clase Factura
