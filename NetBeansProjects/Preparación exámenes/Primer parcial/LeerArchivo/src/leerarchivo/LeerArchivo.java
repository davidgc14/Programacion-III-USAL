package leerarchivo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.nio.file.*;

public class LeerArchivo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Path path = FileSystems.getDefault().getPath("./", "archivo.txt");
		List<String> lista = Files.readAllLines(path, StandardCharsets.UTF_8);
                
                for (int n = 0; n < lista.size(); n++) {
                    System.out.println(lista.get(n));
                }
	}// end of main
} // end of class

