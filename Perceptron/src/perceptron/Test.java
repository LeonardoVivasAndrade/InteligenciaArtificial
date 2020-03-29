package perceptron;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        
        //Compuerta OR      
//        int[][] tv = new int[][]{   {1, 1, 1}, 
//                                    {1, 0, 1}, 
//                                    {0, 1, 1}, 
//                                    {0, 0, 0}  };
        
        //Compuerta AND  
        int[][] tv = new int[][]{   {1, 1, 1}, 
                                    {1, 0, 0}, 
                                    {0, 1, 0}, 
                                    {0, 0, 0}  };
        
        Perceptron p = new Perceptron(tv);
        p.toAprender();

        System.out.println("\nIntroduce Entrada 1: ");
        Scanner leerX1 = new Scanner(System.in);
        double e1 = Double.parseDouble(leerX1.next());

        System.out.println("Introduce Entrada 2: ");
        Scanner leerX2 = new Scanner(System.in);
        double e2 = Double.parseDouble(leerX2.next());

        
        System.out.println("\nSalida: " + p.validar(e1, e2));
        
    }

}
