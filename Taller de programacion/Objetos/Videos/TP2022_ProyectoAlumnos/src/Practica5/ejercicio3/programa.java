/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5.ejercicio3;

/**
 *
 * @author Mateo Spinetti
 */
public class programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventoOcasional e1 = new ShowPrivado("mateo", 22, "coldplay", 2);
        e1.agregarTema("shy full of stars");
        e1.agregarTema("adventure");
        e1.actuar();
        
        Gira g1 = new Gira("Pepa", 5, "Queen", 46);
        g1.agregarFecha(new Fecha("La Plata", 15));
        g1.agregarFecha(new Fecha("Buenos Aires", 13));
        g1.agregarTema("shy full of stars");
        g1.agregarTema("adventure");
        g1.actuar();
        g1.actuar();
        System.out.println(g1.calcularCosto());
        
        
    }
}
