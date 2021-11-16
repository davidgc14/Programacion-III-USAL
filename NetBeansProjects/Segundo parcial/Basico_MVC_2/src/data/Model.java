package data;

public class Model {
    
    private int dato1, dato2, resultado;

    // estos primeros de aqui son para almacenar la informacion en el modelo

    public void setData(int n1, int n2) {
        this.dato1 = n1;
        this.dato2 = n2;
    }

    public void setResult(int result) {
        this.resultado = result;
    }

    // El resto son para devolver al controlador los datos para lo que necesite

    public int devolverDato1() {
        return dato1;
    }

    public int devolverDato2() {
        return dato2;
    }    
    
    public int devolverResultado() {
        return resultado;
    }
}
