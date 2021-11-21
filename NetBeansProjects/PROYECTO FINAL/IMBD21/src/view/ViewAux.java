package view;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.DiaUtil.*;

import controller.Controller;

public class ViewAux {

    static Controller c = new Controller();
    
    // OPCIONES DEL ARCHIVO ---------------------------------------------------

    protected static void exportarArchivoColumnas() {
        
    }

    protected static void exportarArchivoHTML() {
        
    }


    // OPCIONES DEL MENU PELICULAS ---------------------------------------------------  

    protected static void agregarPelicula() {
        String[] nuevaPelicula = new String[11];
        // titulo, año, duracion, pais,[] direccion, guionista, musica,[] reparto, productora, sinopsis, genero;


        clear();
        underline2("Agregar Pelicula");
        nuevaPelicula[0] = readString("Titulo     : ");
        nuevaPelicula[1] = readString("Año        : ");
        nuevaPelicula[2] = readString("Duracion   : ");
        nuevaPelicula[3] = readString("Pais       : ");
        nuevaPelicula[4] = readString("Direccion  : ");
        nuevaPelicula[5] = readString("Guionista  : ");
        nuevaPelicula[6] = readString("Musica     : ");
        nuevaPelicula[7] = readString("Reparto    : ");
        nuevaPelicula[8] = readString("Productora : ");
        nuevaPelicula[9] = readString("Sinopsis   : ");
        nuevaPelicula[10] = readString("Genero     : ");
        
        try {
            c.agregarPelicula(nuevaPelicula);
        } catch (Exception ex) {
            System.out.printf("%n%nERROR DE ESCRITURA: no se ha podido guardar la pelicula correctamente%n%n");
        }

    } // fin agregarPelicula

    protected static void modificarPelicula() {
        
        underline2("Modificar Pelicula");
        // titulo, año, duracion, pais,[] direccion, guionista, musica,[] reparto, productora, sinopsis, genero;

        String nombrePelicula = readString("Nombre de la pelicula a modificar: ");

        boolean encontrado = c.verSiExistePelicula(nombrePelicula);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado la pelicula%n%n");
        } else {

            String[] pelicula ={"titulo", "año", "duracion", "pais", "direccion", "guionista", "musica", "reparto", "productora", "sinopsis", "genero"};

            String parametro = readString("Indique el parámetro que desea modificar ").toLowerCase().trim();

            boolean encontradoEnLista = estaEnLista(pelicula, parametro);

            while (!encontradoEnLista) {
                parametro = readString("Parametro no valido. Indique el parámetro que desea modificar ").toLowerCase().trim();
                encontradoEnLista = estaEnLista(pelicula, parametro);
            }

            try {
                c.modificarPelicula(nombrePelicula, getIndex(pelicula, parametro));
            } catch (Exception ex) {
                System.out.printf("%n%nERROR: no se ha podido modificar la pelicula correctamente%n%n");
            }
        } // fin else
    } // fin modificarPelicula

    protected static void eliminarPelicula() {
        
    }

    protected static void consultarPelicula() {
        
    }


    // OPCIONES DEL MENU DIRECTORES ---------------------------------------------------

    protected static void agregarDirector() {
        
    }

    protected static void modificarDirector() {
        
    }

    protected static void eliminarDirector() {
        
    }


    // OPCIONES DEL MENU ACTORES ---------------------------------------------------

    protected static void agregarActor() {
        
    }

    protected static void modificarActor() {
        
    }

    protected static void eliminarActor() {
        
    }

    protected static void consultarActor() {
        
    }


    // OPCIONES DEL MENU LISTADOS ---------------------------------------------------

    protected static void listadoPeliculas() {
        
    }

    protected static void listadoDirectores() {
        
    }

    protected static void listadoActores() {
        
    }


    // METODOS AUXILIARES ---------------------------------------------------

    private static boolean estaEnLista(String[] lista, String nombre) {
        boolean encontrado = false;
        int i = 0;
        while (i < lista.length && !encontrado) {
            if (lista[i].equals(nombre)) {
                encontrado = true;
            }
            i++;
        }

        return encontrado;
    }

    private static int getIndex(String[] lista, String nombre) {
        int i = 0;
        
        while (i < lista.length) {
            if (lista[i].equals(nombre)) {
                return i;
            }
            i++;
        }
        return -1; // no se encontro
    }

}
