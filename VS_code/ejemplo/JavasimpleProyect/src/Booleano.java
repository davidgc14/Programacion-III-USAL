public class Booleano {
    
    int VarGlobal = 2; // Asi queda definida una variable globalmente
    
    public static void main(String[] args) {
        boolean TF = false;
        
        if (TF == true){
            System.out.println("El booleano vale verdadero: " + TF);
            System.out.println("Es necesario añadir corchete para varias lineas");
        }
        else
            System.out.println("Es falso: " + TF + ". Queda claro el uso del '+'");
    
        // Version compacta:
        // Como vale false, la primera no se ejecuta, pero la segunda si

        if(TF) System.out.println("Esto no se muestra porque vale false"); 
        
        TF = true;
        if(TF) System.out.println("Esto ahora si se muestra"); 

        // Implementación alternativa y directa

        System.out.println(9 > 10); // Lo cual es una afirmación falsa, y así lo ahce ver por pantalla

    }
}
