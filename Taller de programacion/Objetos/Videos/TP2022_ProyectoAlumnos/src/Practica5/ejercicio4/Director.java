/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5.ejercicio4;

/**
 *
 * @author Mateo Spinetti
 */
public class Director extends Persona {
    private int antiguedad;

    public Director(int antiguedad, String nombre, int dni, int edad) {
        super(nombre, dni, edad);
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String toString() {
        String mensaje = super.toString() + "Antiguedad: " + this.antiguedad;
        return mensaje;
    }
}
