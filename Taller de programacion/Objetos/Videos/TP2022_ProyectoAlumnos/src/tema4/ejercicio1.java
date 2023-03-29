/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Mateo Spinetti
 */
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Triangulo t = new Triangulo(10, 15, 20, "amarillo", "verde");
        Circulo c = new Circulo (15, "verde", "azul");
        t.despintar();
        System.out.println (t);
        System.out.println (c);
        
              
        
        
    }
}
