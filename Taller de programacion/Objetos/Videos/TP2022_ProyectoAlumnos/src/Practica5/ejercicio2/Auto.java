/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5.ejercicio2;

/**
 *
 * @author Mateo Spinetti
 */
public class Auto {
    private String nombreDueño, patente;

    public Auto(String nombreDueño, String patente) {
        this.nombreDueño = nombreDueño;
        this.patente = patente;
    }
    

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    public String toString() {
        return "Nombre dueño: " + this.nombreDueño + ", Patente: " + this.patente;
    }
}
