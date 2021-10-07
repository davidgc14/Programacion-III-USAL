import static com.coti.tools.Esdia.*; //ReadFloat y estas cosas


public class sol_05 {

    public static void main(String[] args) {
        float pesoA, pesoB, pesoC;
        double tallaA, tallaB, tallaC;

        // leemos los pesos
        
        pesoA = readFloat("Cuanto pesa Tom ?  ");
        pesoB = readFloat("Cuanto pesa Dick ?  ");
        pesoC = readFloat("Cuanto pesa Harry ?  ");
        

        // leemos las alturas
    
        tallaA = readDouble("Cuanto mide Tom ?  ");
        tallaB = readDouble("Cuanto mide Dick ?  ");
        tallaC = readDouble("Cuanto mide Harry ?  ");


        final float pesoMax =Math.max(Math.max(pesoA, pesoB), pesoC);
        if (pesoMax == pesoA) {
            System.out.printf("El más pesado es Tom : %6.2f %n", pesoA);
        } else if (pesoMax == pesoB) {
            System.out.printf("El más pesado es Dick : %6.2f %n", pesoB);
        } else {
            System.out.printf("El más pesado es Harry : %6.2f %n", pesoC);
        }

        final double tallaMax =Math.max(Math.max(tallaA, tallaB), tallaC);
        if (tallaMax == tallaA) {
            System.out.printf("El más pesado es Tom : %6.2f %n", tallaA);
        } else if (tallaMax == tallaB) {
            System.out.printf("El más pesado es Dick : %6.2f %n", tallaB);
        } else {
            System.out.printf("El más pesado es Harry : %6.2f %n", tallaC);
        }

            
    

    } // end of main
    
} // end of class