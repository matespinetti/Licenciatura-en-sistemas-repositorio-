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
public class Beneficio extends EventoOcasional {

    public Beneficio(String nombreContratante, int dia, String nombreBanda, int cantTemas) {
        super(nombreContratante, dia, nombreBanda, cantTemas);
    }
    
    public String toString(){
        String mensaje = "Recuerden colaborar con " + this.getNombreContratante() + super.toString();
        return mensaje;
    }
    
    
    public void actuar() {
        System.out.println (this.toString());
    }
    
    public double calcularCosto() {
        return 0;
    }
}
