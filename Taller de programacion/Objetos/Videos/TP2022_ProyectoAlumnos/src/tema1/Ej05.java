/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.Lector;
/**
 *
 * @author Mateo Spinetti
 */
public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] vectorC = new int [4];
        
        for (int i = 0; i < 4; i++)
            vectorC [i] = 0;
                
        for (int i = 0; i <5; i++) {
          System.out.println ("Ingrese puntaje de atencion al cliente");
          vectorC [0] += Lector.leerInt();
          System.out.println ("Ingrese puntaje de calidad de comida");
          vectorC [1] += Lector.leerInt();
          System.out.println ("Ingrese puntaje de precio");
          vectorC [2] += Lector.leerInt();
          System.out.println ("Ingrese puntaje de ambiente");
          vectorC [3] += Lector.leerInt();
          
        }
        
        
        
        for (int i = 0; i < 411; i++) {
            double promedio = (double) vectorC[i]/ 5;
            switch (i) {
                case 0: 
                    System.out.println ("El promedio de atencion al cliente es de " + promedio);
                    break;
                case 1:
                    System.out.println ("El promedio de calidad de comida es de " + promedio);
                    break;
                case 2:
                    System.out.println ("El promedio de precio es de " + promedio);
                    break; 
                    
                 case 3:
                    System.out.println ("El promedio de ambiente es de " + promedio);
                    break; 
                               
            }
        }
        

    }
}
