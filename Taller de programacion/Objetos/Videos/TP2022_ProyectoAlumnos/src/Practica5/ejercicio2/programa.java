/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5.ejercicio2;
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
        Estacionamiento estacionamiento = new Estacionamiento ("carrefour", "centenario y 510", "6:00", "23", 3, 3);
        estacionamiento.registrarAuto(new Auto("mateo", "ad311yv"), 2, 1);
        estacionamiento.registrarAuto(new Auto("flor", "ad445cz"), 0, 1);
        estacionamiento.registrarAuto(new Auto("elva", "mrt425"), 1, 1);
        estacionamiento.registrarAuto(new Auto("mauricio", "fer174"), 2, 2);
        estacionamiento.registrarAuto(new Auto("felipe", "ab332nc"), 1, 2);
        System.out.println (estacionamiento);
        System.out.println (estacionamiento.autosPlaza(1));
        System.out.println ("Ingrese una patente a buscar");
        String patente = Lector.leerString();
        System.out.println (estacionamiento.dondeEstaEstacionado(patente));
        
        
    }
}
