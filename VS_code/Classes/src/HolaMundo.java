public class HolaMundo {

    void decirHola(){
        System.out.println("Hello, World!");
    }

    void decirAdios() {
        System.out.println("Later, skater!");
    }
    public static void main(String[] args)  {
        
        HolaMundo ejemplar = new HolaMundo(); // Creamos un ejemplar

        ejemplar.decirHola();
        ejemplar.decirAdios();
    }
}
