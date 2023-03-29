/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

/**
 *
 * @author Mateo Spinetti
 */
public class Pruebaimprimir {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String nombre = "hola";
        String apellido = "chau";
        String [] nombres = new String[10];
        System.out.println(nombres.length);
        
        System.out.printf("My nombre es %s y apellido %s" ,nombre ,apellido);
     
        
    }
}
