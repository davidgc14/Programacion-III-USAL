package view;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.DiaUtil.*;

import controller.Controller;

public class ViewAux {
    
    Controller c;

    public ViewAux(Controller c_viejo) {
        this.c = c_viejo;
    }
    
    // OPCIONES DEL ARCHIVO ---------------------------------------------------

    protected void exportarArchivoColumnas() {
        
    }

    protected void exportarArchivoHTML() {
        
    }


    // OPCIONES DEL MENU PELICULAS ---------------------------------------------------  

    protected void agregarPelicula() {
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

    protected void modificarPelicula() {
        
        underline2("Modificar Pelicula");
        // titulo, año, duracion, pais,[] direccion, guionista, musica,[] reparto, productora, sinopsis, genero;

        String nombrePelicula = readString("Nombre de la pelicula a modificar: ");

        boolean encontrado = c.verSiExistePelicula(nombrePelicula);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado la pelicula%n%n");
        } else {

            String[] pelicula ={"titulo", "año", "duracion", "pais", "direccion", "guionista", "musica", "reparto", "productora", "sinopsis", "genero"};

            String parametro = "";
            boolean encontradoEnLista = false;

            while (!encontradoEnLista || parametro.equals("q")) {
                parametro = readString("Indique el parámetro que desea modificar: ").toLowerCase().trim();

                if (parametro.equals("titulo")) {
                    System.out.printf("%n%nLo sentimos, el titulo no puede ser modificado%n%n");
                } else if (parametro.equals("direccion")) {
                    System.out.printf("%n%nLo sentimos, los directores no pueden ser modificados%n%n");
                } else if (parametro.equals("reparto")) {
                    System.out.printf("%n%nLo sentimos, los actores no pueden ser modificados%n%n");
                } else if (parametro.equals("q")) {
                    return;
                } else if (estaEnLista(pelicula, parametro)) {
                    encontradoEnLista = true;
                } else {
                    System.out.printf("%n%nERROR: no se ha encontrado el parámetro%n%n");
                }
            } // fin while

            String nuevoValor = readString("Indique nuevo/a " + parametro + ": ");

            try {
                c.modificarPelicula(nombrePelicula, getIndex(pelicula, parametro), nuevoValor);
            } catch (Exception ex) {
                System.out.printf("%n%nERROR: no se ha podido modificar la pelicula correctamente%n%n");
            }
        } // fin else
    } // fin modificarPelicula

    protected void eliminarPelicula() {

        
    }

    protected void consultarPelicula() {
        
    }


    // OPCIONES DEL MENU DIRECTORES ---------------------------------------------------

    protected void agregarDirector() {
        
    }

    protected void modificarDirector() {
        
    }

    protected void eliminarDirector() {
        
    }


    // OPCIONES DEL MENU ACTORES ---------------------------------------------------

    protected void agregarActor() {
        
    }

    protected void modificarActor() {
        
    }

    protected void eliminarActor() {
        
    }

    protected void consultarActor() {
        
    }


    // OPCIONES DEL MENU LISTADOS ---------------------------------------------------

    protected void listadoPeliculas() {
        
    }

    protected void listadoDirectores() {
        
    }

    protected void listadoActores() {
        
    }


    // METODOS AUXILIARES ---------------------------------------------------

    private boolean estaEnLista(String[] lista, String nombre) {
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

    private int getIndex(String[] lista, String nombre) {
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
