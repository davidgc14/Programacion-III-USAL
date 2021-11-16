package controller;

import data.Model;

public class Controller {
    
    Model m = new Model();

    public void almacenarDatos(int n1, int n2) {
        // al controlador se le pide guardar los datos (acción)
        // pero los datos son guardados en el modelo
        m.setData(n1, n2);
    }

    public void sumarDatos() {
        int tmp;

        tmp = m.devolverDato1() + m.devolverDato2();

        m.setResult(tmp);
    }

    public int getInfo1() {
        return m.devolverDato1();
    }

    public int getInfo2() {
        return m.devolverDato2();
    }

    public int getResult() {
        return m.devolverResultado();
    }
}
