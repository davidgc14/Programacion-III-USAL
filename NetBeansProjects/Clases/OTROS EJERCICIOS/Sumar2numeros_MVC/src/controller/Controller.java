package controller;

/*
NO CONTIENE DATOS, SOLO CALCULA

EL RESULTADO SE LO MANDA AL MODELO
*/

import data.Model;


public class Controller {
    
    Model m = new Model();
    
    public void storeIntoModel(int num1, int num2) {
        
        // se pide al controlador que guarde los datos
        
        m.setData(num1, num2);
        
    } // end of storeIntoModel
    
    
    public void calculateResults() {
        
        /*
        Se piden los datos al modelo, se calcula el 
        resultado y se pasa el resultado
        al modelo para que lo almacene
        */
        
        // este getInfo no es el mismo (aunque se llame igual) que el que tenemos abajo
        int temp = m.getInfo_1() + m.getInfo_2();
        m.setResults(temp);
        
    } // end of calculateResults
    
    
    public int getInfo_1() {
        
        // se pide informacion al modelo para enviarselo a la vista
        return m.getInfo_1();
        
    } // end of getInfo_1
    
    
    public int getInfo_2() {
        
        // se pide informacion al modelo para enviarselo a la vista
        return m.getInfo_2();

        
    } // end of getInfo_2
    
    
    public int getInfo_result(){
        
        return m.getInfo_result();
        
    } // end of getInfo_result


} // FIN DEL CONTROLADOR
