package auxiliares;


public class ImprimirCosas {
    
    public void imprimirMuchasCosas(String... args) {
        for (String str : args) {
            System.out.println(str);
        }
    } // end of IMPRIMIR_MUCHAS_COSAS
    
    public void imprimir(String variable) {
        System.out.println("Me piden que imprima " + variable);
    }

}
