/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author Mateo Spinetti
 */
public class ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Estante estante1 = new Estante ();
        for (int i = 0; i <=4; i++) {
            System.out.println ("Ingrese el titulo del libro a crear");
            String t = Lector.leerString();
            estante1.addLibro(new Libro (t));
        }
        System.out.println (estante1.getCantLibros());
        Libro libroB = estante1.devolverLibro("Mujercitas");
        if (libroB == null) 
            System.out.println ("No se encontro el libro en el estante");
        else {  
            System.out.println (libroB.getPrimerAutor());
        
        }
            
                    
        
        
    }
}
