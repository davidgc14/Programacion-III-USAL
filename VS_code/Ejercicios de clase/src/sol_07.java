import static com.coti.tools.Esdia.*; //ReadFloat y estas cosas
import static com.coti.tools.DiaUtil.*;

public class sol_07 {
    public static void main(String[] args) {
        final float IVA_FRUTA_FRESCA = 0.04f;

        float kilosPeras, kilosManzs;
        float preciokilosManzs, preciokilosPeras;
        float totalSinIVA, ivaPagado, Totalpagado;
        
        clear();

        kilosPeras = readFloat("Cuantos kilos de peras?  ");
        kilosManzs = readFloat("Cuantos kilos de Manzs?  ");

        preciokilosManzs = readFloat("Cuanto cuesta un kilo de manzs?  ");
        preciokilosPeras = readFloat("Cuanto cuesta un kilo de Peras?  ");

        totalSinIVA = kilosManzs*preciokilosManzs + 
                        kilosPeras*preciokilosPeras;

        ivaPagado = totalSinIVA * IVA_FRUTA_FRESCA;

        Totalpagado = totalSinIVA + ivaPagado;

        System.out.printf("Total sin IVA : %6.2f %n", totalSinIVA);
        System.out.printf("IVA añadido   : %6.2f %n", ivaPagado);
        System.out.printf("Total a pagar : %6.2f %n", Totalpagado);
        
    }
}
