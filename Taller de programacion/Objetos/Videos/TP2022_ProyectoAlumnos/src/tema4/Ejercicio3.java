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
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Persona p = new Persona ("nkunku", 45284325, 18);
        Trabajador t = new Trabajador ("drKlopp" , 2134234, 45, "doctor");
        System.out.println (p);
        System.out.println (t);
    }
}
