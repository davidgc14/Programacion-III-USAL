/**
Este tipo de variables se mantienten ajenas a cuantas clases quieras crear. Si las modificas en una
se modificarán en todas ellas. Al declararlas de forma estática, dicha variable existe una única vez
y por tanto aunque las clases puedan acceder a ella, si alguna lo modifica, lo estará modificando para 
todo el que tenga acceso.

Las variables no estáticas, cada clase lo que hace es crear una copia que modifica a su gusto, y que dicha
modificacion no altera la informacion del resto de clases
 */
class Var {
    static double salario; 
    static String nombre = "Alex";
}


public class VariableEstatica {
    public static void main(String[] args) {
        Var.salario = 1000;

        System.out.println(Var.nombre + " tiene un salario de " + Var.salario);

        /*
        En caso de que en otra clase modifiquemos el valor del salario, si ejecutamos
        de nuevo e imprimimos el salario, este habrá sido modificado
        */
    }
}
