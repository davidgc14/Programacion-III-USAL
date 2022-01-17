package data;

import java.io.Serializable;

public class Actor implements Serializable {
    
    private String nombre;
    private String fechaNacimiento;
    private String nacionalidad;
    private String debut;
    private String[] peliculas;

    // constructor
    public Actor(String nombre, String fechaNacimiento, String nacionalidad, String debut, String[] peliculas) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.debut = debut;
        this.peliculas = peliculas;
    }

    public static Actor factory(String[] datos) {
        if (datos.length == 5) {
            return new Actor(datos[0], 
                            datos[1], 
                            datos[2], 
                            datos[3], 
                            datos[4].split("\t"));
        } else {
            return null;
        }
    }




    // getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.toString();
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


}
