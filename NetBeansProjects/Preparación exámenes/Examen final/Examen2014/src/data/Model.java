package data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;

import com.coti.tools.Rutas;

// import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;

public class Model {

    private ArrayList<Libro> lista = new ArrayList<Libro>();
    
    // importación de datos -------------------------------------------------

    public String importarDatos(File f) {
        if(f.getName().endsWith(".bin")) {
            //Path p = f.toPath();
            return this.importarBinario(f);
        } else if(f.getName().endsWith(".txt")) {
            return this.importarTexto(f);
        } else {
            return "El archivo no tiene una extensión válida";
        }
    }

    private String importarBinario(File f) {
        
        try {
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            lista = (ArrayList<Libro>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            return "Error al importar los datos del archivo binario";
        }
        return null;
    }

    private String importarTexto(File f) {
        
        String[][] tmp;

        try {
            tmp = importFromDisk(f, "#");
        } catch (Exception ex) {
            return "Error al importar los datos de texto";
        }

        for (String[] linea : tmp) {
            if(linea.length != 5) {
                return "Archivo en formato no esperado";
            }
            this.lista.add(Libro.factory(linea));
        }
        
        return null;
    }
    

    // salida de datos ------------------------------------------------------

    public String salirYguardar() {
        
        Path p = Rutas.pathToFileOnDesktop("libros.bin");

        try {
            FileOutputStream fos = new FileOutputStream(p.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(lista);
            oos.close();
        } catch (Exception ex) {
            return "Error al guardar los datos en el archivo binario";
        }
        

        return null;
    }


    // operaciones ----------------------------------------------------------

    public void addLibro(String[] datos) {
        this.lista.add(Libro.factory(datos));
    }

    public void editLibro(int parametro, int puestoEnLista, String nuevoValor) {
        switch(parametro) {
            case 1 -> lista.get(puestoEnLista).setTitulo(nuevoValor);
            case 2 -> lista.get(puestoEnLista).setFecha(Integer.parseInt(nuevoValor));
            case 3 -> lista.get(puestoEnLista).setIsbn(Integer.parseInt(nuevoValor));
        }
    }

    public String imprimirLibro(int puestoEnLista) {
        
        Libro lib = lista.get(puestoEnLista);
        String imprimir = lib.getTitulo().toUpperCase() + 
                        "%nAutor     : " + lib.getAutor() + 
                        "%nEditorial : " + lib.getEditorial() + 
                        "%nISBN      : " + lib.getIsbn() + 
                        "%nFecha     : " + lib.getFecha() + 
                        "%n";
        
        return imprimir;
    }

    public void deleteLibro(int puestoEnLista) {
        this.lista.remove(puestoEnLista);
    }

    public String[][] imprimirLista() {

        String [][] imprimir = new String[lista.size()][5];
        for (Libro lib : lista) {
            imprimir[lista.indexOf(lib)][0] = lib.getTitulo();
            imprimir[lista.indexOf(lib)][1] = lib.getAutor();
            imprimir[lista.indexOf(lib)][2] = lib.getEditorial();
            imprimir[lista.indexOf(lib)][3] = String.valueOf(lib.getIsbn());
            imprimir[lista.indexOf(lib)][4] = String.valueOf(lib.getFecha());
        }

        return imprimir;
    }


    // auxiliares -----------------------------------------------------------

    public int buscarLibro(String nombre) {

        for(int i=0 ; i<lista.size() ; i++) {
            if(lista.get(i).getTitulo().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }


}
