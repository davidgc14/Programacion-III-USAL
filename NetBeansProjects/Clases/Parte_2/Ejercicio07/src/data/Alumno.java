package data;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private final String nombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String DNI;
    private final boolean[] asistencia;

    public Alumno(String nombre, String primerApellido, String segundoApellido, String DNI, boolean[] asistencia) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.DNI = DNI;
        this.asistencia = asistencia;
    }

    // la mision de factory es intentar convertir una lista de cadenas en un ejemplar de Alumno
    static Alumno factory(String[] record){
        
        if (record.length != 5) {
            return null;
        }
        for (int i = 0; i < 5; i++) {
            if (record[i] == null) {
                return null;
            }
        }
        // suponemos que todo va bien
        String[] tmp = record[4].split("#");
        
        if (tmp.length != 16) { // numero de asistencias
            return null;
        }

        boolean[] asistencias = new boolean[16];

        for (int i = 0; i < asistencias.length; i++) {
            asistencias[i] = tmp[i].equalsIgnoreCase("true");
        }

        return new Alumno(
            record[0], 
            record[1], 
            record[2], 
            record[3], 
            asistencias);
    } // end factory


    public String[] stateAsExportList() {
        var bloque_1 = new ArrayList<String>();
        bloque_1.add(this.nombre);
        bloque_1.add(this.primerApellido);
        bloque_1.add(this.segundoApellido);
        bloque_1.add(this.DNI);
        
        var bloque_2 = new ArrayList<String>();
        for (boolean b : this.asistencia) {
            bloque_2.add(b ? "true" : "false");
        }
        bloque_1.add(String.join("#", bloque_2));

        return bloque_1.toArray(new String[0]);
    }


    public String[] stateAsStringList() {
        List<String> tmp = new ArrayList<>();
        tmp.add(this.nombre);
        tmp.add(this.primerApellido);
        tmp.add(this.segundoApellido);
        tmp.add(this.DNI);
        for (boolean b : this.asistencia) {
            tmp.add(b ? "true" : "false");
        }
        return tmp.toArray(new String[0]);
    }


    public int numAsistencias() {
        int resultado = 0;
        for (boolean b : this.asistencia) {
            if (b) {
                resultado++;
            }
        }
        return resultado;
    }

    public boolean[] getAsistencias() {
        return asistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getDNI() {
        return DNI;
    }



    
}