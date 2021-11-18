package data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.coti.tools.OpMat.*;

public class Model {

    private List<String[]> lista = new ArrayList<>();
    
    public String leerArchivo(File rutaArchivo) {

        // primero tenemos que ver si existe
        if (!rutaArchivo.exists()) {
            return "%nERROR: archivo no existente";
        }

        // ahora que sabemos que existe, podmeos empezar a trabajar con el
        // como es un archivo separado por tabuladores, guardaremos los datos en una matriz

        String[][] tmp;

        // ahora yo lo que quiero es meter los datos en la matriz, pero existe la posibilidad
        // de que el archivo no esté como yo quiero

        try {
            tmp = importFromDisk(rutaArchivo, "\t");
        } catch (Exception ex) {
            return "%nERROR: El archivo no se pudo leer como se esperaba";
        }

        // Si hemos llegado hasta aqui es porque el archivo existe y lo hemos podido
        // leer como queríamos, y ahora lo tenemos almacenado en String tmp

        // vamos a guardar por filas la matriz tmp en la lista del Modelo para que quede almacenado
        
        // Esta es una lista genérica, si cad linea fuera de un constructor concreto, la lista deberia serlo tambien
        for (String[] s : tmp) {
            if (s != null) {
                this.lista.add(s);
            }
        }


        // como no hemos tenido problemas hasta ahora, devolvemos informacion diciendo que todo ha ido bien
        return "";
    }


    public void imprimirDatos() {

        // List<String> aux = new ArrayList<>();
        // int aux;

        for (String[] s : this.lista) {
            for (String sub_s : s) {

                System.out.printf("%-20s", sub_s);
            }
            System.out.println();
        }
    }
}
