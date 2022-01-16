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
}
