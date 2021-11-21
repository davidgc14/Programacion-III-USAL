package data;

public class Actor {

    private String nombre;
    private String fechaNacimiento;
    private String nacionalidad;
    private String debut;
    private String[] peliculas;

    // CONSTRUCTOR

    public Actor(String nombre, String fechaNacimiento, String nacionalidad, String debut, String[] peliculas) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.debut = debut;
        this.peliculas = peliculas;
    }


    // FACTORY
    static Actor factory(String[] datos) {
        Actor act = new Actor(datos[0], datos[1], datos[2], datos[3], datos[4].split(","));
        return act;
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

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(String[] peliculas) {
        this.peliculas = peliculas;
    }

    /*
    @Override
    public String toString() {
        return "Actor{" + "nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", nacionalidad=" + nacionalidad + ", debut=" + debut + ", peliculas=" + peliculas + '}';
    }
    */

} // end class Actor