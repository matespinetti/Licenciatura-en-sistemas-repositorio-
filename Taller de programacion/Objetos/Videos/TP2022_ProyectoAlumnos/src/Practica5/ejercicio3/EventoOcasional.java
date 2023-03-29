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
public abstract class EventoOcasional extends Recital {
    private String nombreContratante;
    private int dia;

    public EventoOcasional(String nombreContratante, int dia, String nombreBanda, int cantTemas) {
        super(nombreBanda, cantTemas);
        this.nombreContratante = nombreContratante;
        this.dia = dia;
    }
    
    

    public String getNombreContratante() {
        return nombreContratante;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    
    public abstract double calcularCosto();
    
    
}
