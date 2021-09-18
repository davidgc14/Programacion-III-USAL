// Esta clase la podremos llamar dentro de otras funciones y otras clases
class Puntos {
    int PuntosJuan; // Definimos en una clase, un conjunto de variables
    int PuntosPablo; // Que podremos clasificar segun cada partida que juguemos
    int PuntosDavid;
}

public class VariableInstancia {
    public static void main(String[] args) {

        // Definimos un nuevo elemento (una nueva partida)
        // que almacenará las puntuaciones de los tres jugadores
        // Tiene estructura similar a un vector en este caso
        Puntos Partida_1 = new Puntos(); 
        // Definimos Partida_1 como un NUEVO (new) elemento de tipo puntos
        Partida_1.PuntosDavid = 30;
        Partida_1.PuntosJuan = 40;
        Partida_1.PuntosPablo = 10;
        // Asi tenemos almacenados las puntuaciones de la primera partida. 
        // Podemos definir tantas partidas como queramos

        Puntos Partida_2 = new Puntos();

        Partida_2.PuntosDavid = 50;
        Partida_2.PuntosJuan = 20;
        Partida_2.PuntosPablo = 40;


        //mostramos los puntos para el primer objeto
        System.out.println("Puntos para el primer objeto:");
        System.out.println(Partida_1.PuntosDavid);
        System.out.println(Partida_1.PuntosJuan);
        System.out.println(Partida_1.PuntosPablo);
     
        //mostramos los puntos para el segundo objeto
        System.out.println("Puntos para el segundo objeto:");
        System.out.println(Partida_2.PuntosDavid);
        System.out.println(Partida_2.PuntosJuan);
        System.out.println(Partida_2.PuntosPablo);
    }
}
