package data;

// import com.coti.tools.*;

public class Factura {

    // variables del constructor
    private float descuento;
    private float importe;
    private float tipoDeIVA;
    private String concepto;
    private String fecha;
    private String NIF;
    private String nombre;
    private String direccion;

    //constructor
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
        this.concepto = "DESCONOCIDO";
        this.descuento = 0;
        this.fecha = "DESCONOCIDO";
        this.importe = 0;
        this.NIF = "DESCONOCIDO";
        this.nombre = "DESCONOCIDO";
        this.direccion = "DESCONOCIDO";
        this.tipoDeIVA = 0;
    }

    public static Factura factory(String[] s) {
        
        // como es de tipo factura, debe devolver una factura, luego la definimos
        Factura fac = new Factura();
        
        fac.concepto = s[0];
        fac.descuento = Float.parseFloat(s[1]);
        fac.fecha = s[2];
        fac.importe = Float.parseFloat(s[3]);
        fac.NIF = s[4];
        fac.nombre = s[5];
        fac.direccion = s[6];
        fac.tipoDeIVA = Float.parseFloat(s[7]);       
        
        return fac;
        
    }

    public String[] datosFactura() {

        String[] rd = {
            this.concepto,
            String.valueOf(this.descuento),
            this.fecha,
            String.valueOf(this.importe),
            this.NIF,
            this.nombre,
            this.direccion,
            String.valueOf(this.tipoDeIVA),
        };

        return rd;
    }
}
