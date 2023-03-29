/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialLibros;
import PaqueteLectura.Lector;

/**
 *
 * @author Mateo Spinetti
 */
public class programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LibroElectronico le = new LibroElectronico ("pdf", 50, "harry potter", 1000);
        LibroImpreso li = new LibroImpreso (false, "uncharted", 700);
        for (int i = 0; i < 3; i ++) {
            System.out.println ("Ingrese el nombre del autor de " + le.getTitulo());
            String nombre = Lector.leerString();
            le.agregarAutor(nombre);
            
            System.out.println ("Ingrese el nombre del autor de " + li.getTitulo());
            nombre = Lector.leerString();
            li.agregarAutor(nombre);
        }
        
        System.out.println(le);
        System.out.println(li);
    }
}
