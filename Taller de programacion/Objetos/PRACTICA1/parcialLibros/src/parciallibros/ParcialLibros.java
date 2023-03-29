/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciallibros;
import PaqueteLectura.Lector;

/**
 *
 * @author Mateo Spinetti
 */
public class ParcialLibros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estanteria estanteria = new Estanteria (5, 3);
        for (int i = 0; i < 3; i ++) {
            System.out.println ("Titulo: ");
            String titulo = Lector.leerString();
            System.out.println("Nombre primer autor: ");
            String nombreAutor = Lector.leerString();
            System.out.println ("Peso: ");
            Double peso = Lector.leerDouble();
            System.out.println("Numero estante: ");
            int nEstante = Lector.leerInt();
            
            estanteria.almacenarLibro(new Libro (titulo, nombreAutor, peso), nEstante);
        }
        
       
       
        System.out.println ("El numero de estante mas pesado es " + estanteria.calcular());
        
    }
    
}
