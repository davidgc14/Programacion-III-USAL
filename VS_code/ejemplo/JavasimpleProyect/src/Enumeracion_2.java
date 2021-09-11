enum Transporte {
    COCHE, AVION, CAMION, BARCO, TREN;
}

public class Enumeracion_2 {
    public static void main(String[] args) {
        Transporte tp;
        tp = Transporte.AVION;

        System.out.println("Valor del transporte guardado: " + tp);
        System.out.println();

        if(tp == Transporte.AVION)
            System.out.println("Efectivamente es un avión. Veamos que dice el switch:");
            System.out.println();

        switch(tp){
            case COCHE:
                System.out.println("Un auto lleva personas.");
                break;
            case CAMION:
                System.out.println("Un camión lleva carga.");
                break;
            case AVION:
                System.out.println("Un avión vuela.");
                break;
            case TREN:
                System.out.println("Un tren corre sobre rieles.");
                 break;
            case BARCO:
                System.out.println("Un barco navega en el agua.");
                break;
        }
    }
}