public class ClasePrincipal {
    // definimos nueva variable numérica con el mismo nombre de la clase
    int Numero = 20;
    // esta variable se ha definido antes del main, es una variable "global"?

    // construimos el main
    public static void main(String[] args) {
        
        ClasePrincipal AlgoIntermedio = new ClasePrincipal();

        System.out.println(AlgoIntermedio);

        System.out.println(AlgoIntermedio.Numero);
    }
    
}
