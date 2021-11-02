public class Break {
    public static void main(String[] args) {
        int indice; 
        int[] lista = {1, 2, 6, 4 , 5, 22};
        int buscado = 2;

        for (int i : lista) {
            if (lista[i] == buscado) {
                indice = i;
                System.out.printf("El numero %d se encuentra en la posición %d", buscado, indice);
                break;
            }
        }

    }
}
