package data;


// datos no es una clase con main, luego no es ejecutable
// puede ser llamada pero no ejecutada de forma aislada
public class Datos {
    
    // estos son los atributos de la clase
    float parcial1, parcial2, parcial3;
    float media;
    

    // METODOS


    // Metodo constructor, ejecutado automaticamente al usar la función 'new'
    public Datos(float p1, float p2, float p3) {
        
        this.parcial1 = p1;
        this.parcial2 = p2;
        this.parcial3 = p3;
    }

    // Calculo de la nota media
    // como es un void NO DEVUELVE NADA, el valor se queda guardado en el atributo de la clase
    public void calcularMedia() {
        this.media = (this.parcial1 + this.parcial2 + this.parcial3) / 3.0f;
    }

    // para que se pueda acceder de forma externa a la media del constructor
    public float getMedia() {
        return media;
    }


    // sirve para devolver el estado de la clase
    // devuelve una cadenaque contiene todos los atributos de la clase
    @Override
    public String toString() {
        this.calcularMedia();
        
        // Devolvemos el formato preparado para ser impreso
        return String.format("|%6.2f|%6.2f|%6.2f|%6.2f|", 
                                this.parcial1, 
                                this.parcial2, 
                                this.parcial3, 
                                this.media);
    }
}
