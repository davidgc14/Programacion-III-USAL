package data;

public class Persona {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    // constructor
    public Persona(String nombre, String primerApellido, String segundoApellido) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public Persona() {
        this.nombre = "empty";
        this.primerApellido = "empty";
        this.segundoApellido = "empty";
    }


    static Persona factory(String[] datos) {
        
        // Esto estaría bien si supieramos que todos los datos son del tipo que esperamos
        // 
        // return new Persona(datos[0], datos[1], datos[2]);
        //
        // pero eso no lo sabemos a ciencia cierta

        Persona per = new Persona();

        try {
            per.nombre = datos[0];
            per.primerApellido = datos[1];
            per.segundoApellido = datos[2];
        } catch (Exception ex) {
            return null;
        }

        return per;
    }
    
    public String[] toStringArray() {
        return new String[] {this.nombre, this.primerApellido, this.segundoApellido};
    }


    // GETTERS Y SETTERS
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

} // end class Persona
