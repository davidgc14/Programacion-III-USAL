// Esto no será una clase, será un nuevo tipo de enumeración
enum Colores {
    ROJO, VERDE, AZUL; // CONSTANTES DE ENUMERACION
}
public class Enumeracion_1 {
    public static void main(String[] args) {
        // Ahora podemos asignar un color concreto a cualquier variable
        // Colores es para nosotros ahora un nuevo tipo de variable
        Colores c1 = Colores.ROJO;
        System.out.println(c1);

    }
}
