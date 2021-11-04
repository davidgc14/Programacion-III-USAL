package data;

/*
SOLO CONTIENE DATOS, 

RECIBE DATOS DEL CONTROLADOR Y LA AMACENA
*/


/*
LA VISTA NUNCA PIDE DATOS AL VISTA, SIEMPRE AL CONTROLADOR
*/
public class Model {
    
    private int info1, info2, result;
    
    
    public void setData(int num1, int num2) {

        this.info1 = num1;
        this.info2 = num2;
        
    }
    
    
    public int getInfo_1() {
        
        return this.info1;
        
    }
    
    
    public int getInfo_2() {
        
        return this.info2;
        
    }

    
    public void setResults(int temp) {
        
        this.result = temp;
        
    }
    
    
    public int getInfo_result() {
        
        return this.result;
        
    }

}
