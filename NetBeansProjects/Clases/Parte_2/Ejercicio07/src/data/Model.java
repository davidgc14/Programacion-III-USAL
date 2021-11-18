package data;

// REVISADO Y CORRECTO

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator; // NUEVO!!!


public class Model {
    
    private List<Alumno> listaAlumnos;
    
    
    public void setTablaGeneral(String[][] tabla) {
        listaAlumnos = new ArrayList<>();
        
        for (String[] record : tabla) {
            Alumno alum = Alumno.factory(record);
            
            if (alum != null) { // intento meter el alumno en la lista
                listaAlumnos.add(alum);
            }
        }
    }


    public String[][] tablaGeneral() {
        if (listaAlumnos == null || listaAlumnos.isEmpty()) {
            return null;
        }
        String[][] resultado = new String[listaAlumnos.size()][];

        /*
        var lista = listaAlumnos.listIterator();
        while (lista.hasNext()) {
            resultado[lista.nextIndex()] = lista.next().stateAsStringList();
        }
        */

        // Otra forma de hacerlo:
        
        for (int i = 0; i < listaAlumnos.size(); i++) {
            resultado[i] = listaAlumnos.get(i).stateAsStringList();
        }
        return resultado;
    }


    public String[][] tablaPocaAsistencia() {
        if (listaAlumnos == null || listaAlumnos.isEmpty()) {
            return null;
        }
        List<Alumno> tmp = new ArrayList<>();
        for (Alumno alum : listaAlumnos) {
            if (alum.numAsistencias() <= 7) {
                tmp.add(alum);
            }
        }
        
        
        String[][] resultado = new String[listaAlumnos.size()][];

        /*
        var lista = listaAlumnos.listIterator();
        while (lista.hasNext()) {
            resultado[lista.nextIndex()] = lista.next().stateAsStringList();
        }
        */

        // Otra forma de hacerlo:
        
        for (int i = 0; i < listaAlumnos.size(); i++) {
            resultado[i] = listaAlumnos.get(i).stateAsStringList();
        }
        return resultado;
    }


    public String[][] getTablaGeneral() {
        if (listaAlumnos == null || listaAlumnos.isEmpty()) {
            return null;
        }

        String[][] resultado = new String[listaAlumnos.size()][];

        for (int i = 0; i < listaAlumnos.size(); i++) {
            resultado[i] = listaAlumnos.get(i).stateAsExportList();
        }

        return resultado;
    }


    // revisar
    public String[][] getTablaPocaAsistencia() {
        if (listaAlumnos == null || listaAlumnos.isEmpty()) {
            return null;
        }

        List<Alumno> tmp = new ArrayList<>();
        for (Alumno alum : listaAlumnos) {
            if (alum.numAsistencias() <= 7) {
                tmp.add(alum);
            }
        }
        
        String[][] resultado = new String[listaAlumnos.size()][];

        for (int i = 0; i < listaAlumnos.size(); i++) {
            resultado[i] = listaAlumnos.get(i).stateAsExportList();
        }

        return resultado;
    }



    public void ordenarListaGeneral() {
        listaAlumnos.sort(Comparator.comparing(Alumno::getPrimerApellido)
            .thenComparing(Alumno::getSegundoApellido)
            .thenComparing(Alumno::getNombre));   
    }


    public void ordenarPorAsistencia() {
        listaAlumnos.sort(Comparator.comparing(Alumno::numAsistencias));
    }






 

}
