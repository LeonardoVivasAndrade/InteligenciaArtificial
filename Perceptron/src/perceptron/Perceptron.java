
package perceptron;

import java.util.Random;
/*
* Perceptron Simple de dos entradas con Aprendizaje de Error
* Se extrae de https://thales.cica.es/rd/Recursos/rd98/TecInfo/07/capitulo4.html
*/

public class Perceptron {
    
    private int[][] tv;
    private double w1;
    private double w2;
    private double umbral;
    private double y;
    private double E;//Factor de aprendizaje
    private int it = 0;

    public Perceptron(int[][]tv) {
        this.tv = tv;       
        this.w1 = new Random().nextDouble();
        this.w2 = new Random().nextDouble();
        this.umbral = new Random().nextDouble();
        this.y = 0; 
        this.E = 0.2;
    }
    
    public void toAprender(){
        int i = 0;
        while (i < tv.length && it < 100) {
            
            y = validar(tv[i][0], tv[i][1]);
            
            //si la validacion es correcta con la salida
            if (y == tv[i][2]) {
                i++;
            //si no es correcta la validacion, aprende!
            } else {
                //Ajuste de pesos. Formula (peso = peso + factorAprendizaje * (salidaEsperada - salida) * entrada
                w1 = w1 + E * (tv[i][2] - y) * (tv[i][0]);
                w2 = w2 + E * (tv[i][2] - y) * (tv[i][1]);
                //Ajuste de umbral. Formula (umbral = umbral + factorAprendizaje * (salidaEsperada - salida)
                umbral = umbral + E * (tv[i][2] - y);
                it++;
                i = 0;
            }
        }   
    }
    
    
    
    public double validar(double e1, double e2){
        double y = Math.tanh(e1 * w1 + e2 * w2 + umbral);
        return (y >= 0) ? 1 : 0;       
    }    
    
    public int[][] getTv() {
        return tv;
    }

    public void setTv(int[][] tv) {
        this.tv = tv;
    }

    public double getW1() {
        return w1;
    }

    public void setW1(double w1) {
        this.w1 = w1;
    }

    public double getW2() {
        return w2;
    }

    public void setW2(double w2) {
        this.w2 = w2;
    }

    public double getUmbral() {
        return umbral;
    }

    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }   

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }    

    public double getE() {
        return E;
    }

    public void setE(double E) {
        this.E = E;
    }
    
}
