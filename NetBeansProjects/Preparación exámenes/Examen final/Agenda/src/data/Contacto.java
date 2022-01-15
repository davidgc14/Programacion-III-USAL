package data;

public class Contacto {

    private String nombre;
    private String apellido;
    private int numero;
    
    public Contacto(String nombre, String apellido, int numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero; 
    }

    static Contacto factory(String[] nuevo) {
        if (nuevo.length != 3) {
            return null;
        }
        return new Contacto(nuevo[0], nuevo[1], Integer.parseInt(nuevo[2]));
    }


    // GEETERS AND SETTERS ---------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
