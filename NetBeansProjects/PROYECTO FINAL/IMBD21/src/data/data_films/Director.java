package data.data_films;

public class Director {
    
    private String nombre;
    private String fechaNacimiento;
    private String nacionalidad;
    private String ocupacion;
    private String[] peliculas;

    // CONSTRUCTOR

    public Director(String nombre, String fechaNacimiento, String nacionalidad, String ocupacion, String[] peliculas) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.ocupacion = ocupacion;
        this.peliculas = peliculas;
    }

    // FACTORY
    static Director factory(String[] datos) {
        Director dir = new Director(datos[0], datos[1], datos[2], datos[3], datos[4].split(","));
        return dir;
    }

    // GETTERS & SETTERS  ---------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(String[] peliculas) {
        this.peliculas = peliculas;
    }
} // end class Director

