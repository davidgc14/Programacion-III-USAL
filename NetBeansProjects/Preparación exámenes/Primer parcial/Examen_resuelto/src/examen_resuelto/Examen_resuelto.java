package examen_resuelto;

import static com.coti.tools.Esdia.*;


public class Examen_resuelto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] nom = new String[5];
        int[] num = new int[5];
        float[] pre = new float[5];
        final float IVA = 0.33f;
        System.out.println("ZAPATERIA");
        
        // leer nombre de los modelos
        float costeSinIVA = 0.0f;
        float masCaro = pre[0];
        for (int i = 0 ; i < 5 ; i++) {
            nom[i] = readString("Nombre del modelo           " + i + " : ");
            num[i] = readInt   ("Numero de zapatos del modelo" + i + " : ");
            pre[i] = readFloat ("Precio del modelo           " + nom[i] + " : ");
            costeSinIVA += pre[i] * num[i];
            if (pre[i] > masCaro){
                masCaro = pre[i];
            } // end if
        
        } // end for
        
        // ===============
        // SIN TERMINAR
        // ===============
        
    } // end of main
    
} // end of class
