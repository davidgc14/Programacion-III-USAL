package view;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.OpMat.*;

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
        String nombrePelicula = readString("Nombre de la pelicula a eliminar: ");

        boolean encontrado = c.verSiExistePelicula(nombrePelicula);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado la pelicula%n%n");
        } else {
            String decision = readString("Seguro que quiere eliminar la pelicula " + nombrePelicula.toUpperCase() + "? (s/n): ").toLowerCase();

            if (decision.equals("s")) {
                System.out.printf("%n%nEliminando pelicula...%n");
                try {
                    c.eliminarPelicula(nombrePelicula);
                } catch (Exception ex) {
                    System.out.printf("%n%nERROR: no se ha podido eliminar la pelicula correctamente%n%n");
                }
            } else {
                System.out.printf("%n%nPelicula no eliminada%n%n");
            }
        }
    } // fin eliminarPelicula
        
    protected void consultarPelicula() {
        System.out.printf("%n");
        String nombrePelicula = readString("Nombre de la pelicula a consultar: ");

        boolean encontrado = c.verSiExistePelicula(nombrePelicula);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado la pelicula%n%n");
        } else {
            System.out.printf("%n%nPelicula encontrada%n%n");
            System.out.printf("%n%n%n");
            String[][] tmp = c.consultarPelicula(nombrePelicula);
            try {
                printToScreen3(tmp);
            } catch (Exception ex) {
                System.out.printf("%n%nERROR: no se ha podido consultar la pelicula correctamente%n%n");
            }
            System.out.printf("%n%n%n");
        }
    } // fin consultarPelicula


    // OPCIONES DEL MENU DIRECTORES ---------------------------------------------------

    protected void agregarDirector() {
        String[] nuevoDirector = new String[5];
        // nombre, fechaNacimiento, nacionalidad, ocupacion, [] peliculas;

        clear();
        underline2("Agregar Director");

        nuevoDirector[0] = readString("Nombre              : ");
        nuevoDirector[1] = readString("Fecha de nacimiento : ");
        nuevoDirector[2] = readString("Nacionalidad        : ");
        nuevoDirector[3] = readString("Ocupacion           : ");
        nuevoDirector[4] = readString("Peliculas           : ");

        try {
            c.agregarDirector(nuevoDirector);
        } catch (Exception ex) {
            System.out.printf("%n%nERROR DE ESCRITURA: no se ha podido guardar el director correctamente%n%n");
        }
    } // fin agregarDirector

    protected void modificarDirector() {
        clear();
        underline2("Modificar Director");
        // nombre, fechaNacimiento, nacionalidad, ocupacion, [] peliculas;

        String nombreDirector = readString("Nombre del director a modificar: ");

        boolean encontrado = c.verSiExisteDirector(nombreDirector);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado el director%n%n");
        } else {

            String[] director ={"nombre", "fechaNacimiento", "nacionalidad", "ocupacion", "peliculas"};

            String parametro = "";
            boolean encontradoEnLista = false;

            while (!encontradoEnLista || parametro.equals("q")) {
                parametro = readString("Indique el parámetro que desea modificar: ").toLowerCase().trim();

                if (parametro.equals("peliculas")) {
                    System.out.printf("%n%nLo sentimos, las peliculas no pueden ser modificadas%n%n");
                } else if (parametro.equals("nombre")) {
                    System.out.printf("%n%nLo sentimos, el nombre no puede ser modificado%n%n");
                } else if (parametro.equals("q")) {
                    return;
                } else if (estaEnLista(director, parametro)) {
                    encontradoEnLista = true;
                } else {
                    System.out.printf("%n%nERROR: no se ha encontrado el parámetro%n%n");
                }
            } // fin while

            String nuevoValor = readString("Indique nuevo/a " + parametro + ": ");

            try {
                c.modificarDirector(nombreDirector, getIndex(director, parametro), nuevoValor);
            } catch (Exception ex) {
                System.out.printf("%n%nERROR: no se ha podido modificar el director correctamente%n%n");
            }
        } // fin else
    } // fin modificarDirector

    protected void eliminarDirector() {
        String nombreDirector = readString("Nombre del director a eliminar: ");

        boolean encontrado = c.verSiExisteDirector(nombreDirector);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado el director%n%n");
        } else {
            String decision = readString("Seguro que quiere eliminar el director " + nombreDirector.toUpperCase() + "? (s/n): ").toLowerCase();

            if (decision.equals("s")) {
                System.out.printf("%n%nEliminando director...%n");
                try {
                    c.eliminarDirector(nombreDirector);
                } catch (Exception ex) {
                    System.out.printf("%n%nERROR: no se ha podido eliminar el director correctamente%n%n");
                }
            } else {
                System.out.printf("%n%nDirector no eliminado%n%n");
            }
        }
    } // fin eliminarDirector
    

    // OPCIONES DEL MENU ACTORES ---------------------------------------------------

    protected void agregarActor() {
        String[] nuevoActor = new String[5];
        // nombre, fechaNacimiento, nacionalidad, debut, [] peliculas;

        clear();
        underline2("Agregar Actor");

        nuevoActor[0] = readString("Nombre              : ");
        nuevoActor[1] = readString("Fecha de nacimiento : ");
        nuevoActor[2] = readString("Nacionalidad        : ");
        nuevoActor[3] = readString("Debut               : ");
        nuevoActor[4] = readString("Peliculas           : ");

        try {
            c.agregarActor(nuevoActor);
        } catch (Exception ex) {
            System.out.printf("%n%nERROR DE ESCRITURA: no se ha podido guardar el actor correctamente%n%n");
        }
    } // fin agregarActor

    protected void modificarActor() {
        clear();
        underline2("Modificar Actor");
        // nombre, fechaNacimiento, nacionalidad, debut, [] peliculas;

        String nombreActor = readString("Nombre del actor a modificar: ");

        boolean encontrado = c.verSiExisteActor(nombreActor);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado el actor%n%n");
        } else {

            String[] actor ={"nombre", "fechaNacimiento", "nacionalidad", "debut", "peliculas"};

            String parametro = "";
            boolean encontradoEnLista = false;

            while (!encontradoEnLista || parametro.equals("q")) {
                parametro = readString("Indique el parámetro que desea modificar: ").toLowerCase().trim();

                if (parametro.equals("peliculas")) {
                    System.out.printf("%n%nLo sentimos, las peliculas no pueden ser modificadas%n%n");
                } else if (parametro.equals("nombre")) {
                    System.out.printf("%n%nLo sentimos, el nombre no puede ser modificado%n%n");
                } else if (parametro.equals("q")) {
                    return;
                } else if (estaEnLista(actor, parametro)) {
                    encontradoEnLista = true;
                } else {
                    System.out.printf("%n%nERROR: no se ha encontrado el parámetro%n%n");
                }
            } // fin while

            String nuevoValor = readString("Indique nuevo/a " + parametro + ": ");

            try {
                c.modificarActor(nombreActor, getIndex(actor, parametro), nuevoValor);
            } catch (Exception ex) {
                System.out.printf("%n%nERROR: no se ha podido modificar el actor correctamente%n%n");
            } // fin try
        } // fin else
    } // fin modificarActor

    protected void eliminarActor() {
        String nombreActor = readString("Nombre del actor a eliminar: ");

        boolean encontrado = c.verSiExisteActor(nombreActor);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado el actor%n%n");
        } else {
            String decision = readString("Seguro que quiere eliminar el actor " + nombreActor.toUpperCase() + "? (s/n): ").toLowerCase();

            if (decision.equals("s")) {
                System.out.printf("%n%nEliminando actor...%n");
                try {
                    c.eliminarActor(nombreActor);
                } catch (Exception ex) {
                    System.out.printf("%n%nERROR: no se ha podido eliminar el actor correctamente%n%n");
                }
            } else {
                System.out.printf("%n%nActor no eliminado%n%n");
            }
        }
    } // fin eliminarActor

    protected void consultarPeliculasActor() {
        String nombreActor = readString("Nombre del actor: ");

        boolean encontrado = c.verSiExisteActor(nombreActor);

        if (!encontrado) {
            System.out.printf("%n%nERROR: no se ha encontrado el actor%n%n");
        } else {
            String[][] peliculasOrdenadas = c.consultarPeliculasActor(nombreActor);

            if (peliculasOrdenadas == null) {
                System.out.printf("%n%nERROR: no se ha encontrado ninguna pelicula%n%n");
            } else {
                try {
                    System.out.printf("%n%nPeliculas del actor:%n%n");
                    printToScreen3(peliculasOrdenadas);
                } catch (Exception ex) {
                    System.out.printf("%n%nERROR: no se ha podido mostrar las peliculas correctamente%n%n");
                }
            }
        } // fin else
    } // fin consultarPeliculasActor


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
