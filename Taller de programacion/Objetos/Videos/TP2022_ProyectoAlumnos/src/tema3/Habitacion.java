/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Mateo Spinetti
 */
public class Habitacion {
    private double costoNoche;
    private boolean ocupada;
    private Cliente cliente;

    public Habitacion() {
        this.ocupada = false;
        this.costoNoche = GeneradorAleatorio.generarDouble(6000) + 2000;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getCostoNoche() {
        return costoNoche;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.ocupada = true;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return ("Costo: " + costoNoche + " ocupada: " + ocupada);
    }
    
    
}
