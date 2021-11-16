package fruteria;

import java.io.*;
import static com.coti.tools.Esdia.readFloat;

public class Fruteria {
	public static void main(String[] args) {
		String[] fruta = {"Manzana","Pera"};
		float[] precio = new float[fruta.length];
                float IVA = 0.20f;
                
                //clear();
                
		for (int i = 0; i < fruta.length; i++) {
			precio[i] = readFloat("Introducir precio-kilo de " + fruta[i] + " : ");
		}
                
                System.out.println("");
                System.out.println("FRUTERIA");
                System.out.println("");
                
                float[] kilos = new float[fruta.length];
                
		for (int i = 0; i < fruta.length; i++) {
			kilos[i] = readFloat("Introducir kilos deseados de " + fruta[i] + " : ");
		}
                
                float precioSinIVA = 0f, precioConIVA = 0f;
                
		for (int i = 0; i < fruta.length; i++) {
			precioSinIVA += precio[i] * kilos[i];
		}
                
                precioConIVA = precioSinIVA * (IVA + 1);
                
                System.out.println("");
                System.out.println("PRECIOS");
                
                System.out.println("TOTAL   : " + precioSinIVA);
                System.out.println("IVA     : " + IVA*precioSinIVA);
                System.out.println("A PAGAR : " + precioConIVA);

                
	}
}