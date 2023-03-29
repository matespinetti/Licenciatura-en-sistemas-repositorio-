/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Mateo Spinetti
 */
public abstract class Empleado {
    private String nombre;
    private Double sueldo;
    private int Antiguedad;

    public Empleado(String nombre, Double sueldo, int Antiguedad) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.Antiguedad = Antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return Antiguedad;
    }

    public void setAntiguedad(int Antiguedad) {
        this.Antiguedad = Antiguedad;
    }
    
    public double calcularSueldo () {
        double aux = this.getSueldo();
        aux += aux *(double)this.getAntiguedad() / 10;
        return aux;
    }
    
    public abstract double calcularEfectividad ();
    

    @Override
    public String toString() {
        String mensaje = String.format("Nombre: %s, sueldo: %.2f, efectividad: %.2f%%", this.getNombre(), this.calcularSueldo(), this.calcularEfectividad());
        return mensaje;
    }
    
    
    
    
}
