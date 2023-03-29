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
public class Gira extends Recital {
   private String nombre;
   private Fecha [] fechas;
   private int cantFechas;
   private int proxima;

    public Gira(String nombre, int cantFechas, String nombreBanda, int cantTemas) {
        super(nombreBanda, cantTemas);
        this.nombre = nombre;
        this.fechas = new Fecha [cantFechas];
        this.proxima = 0;
        this.cantFechas = 0;
    }
   
    public void agregarFecha (Fecha fecha) {
        if (this.cantFechas < this.fechas.length) {
            this.fechas[cantFechas] = fecha;
            cantFechas++;
        }
    }
    public String toString() {
        String mensaje = "Buenas noches " + this.fechas[proxima].getCiudad();
        this.proxima++;
        return mensaje;
    }
    
    public void actuar () {
        System.out.println (this.toString() + super.toString());
    }
    public double calcularCosto() {
        return 30000 * cantFechas;
    }
    
   
}
