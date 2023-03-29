/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.Lector;
/**
 *
 * @author Mateo Spinetti
 */
public class ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Persona p1 = new Persona ();
        System.out.println ("Nombre: ");
        p1.setNombre(Lector.leerString());
        System.out.println ("Edad: ");
        p1.setEdad(Lector.leerInt());
        System.out.println ("Dni: ");
        p1.setDNI(Lector.leerInt());
        System.out.println(p1);
    }
}
