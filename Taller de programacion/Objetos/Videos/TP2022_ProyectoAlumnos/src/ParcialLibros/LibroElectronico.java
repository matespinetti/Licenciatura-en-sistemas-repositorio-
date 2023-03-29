/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialLibros;

/**
 *
 * @author Mateo Spinetti
 */
public class LibroElectronico extends Libro {
    private String formato;
    private int tamañoMb;

    public LibroElectronico(String formato, int tamañoMb, String titulo, double precioBase) {
        super(titulo, precioBase);
        this.formato = formato;
        this.tamañoMb = tamañoMb;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getTamañoMb() {
        return tamañoMb;
    }

    public void setTamañoMb(int tamañoMb) {
        this.tamañoMb = tamañoMb;
    }
    
    public double obtenerPrecioFinal() {
        return this.getPrecioBase() + 2.5 * this.getTamañoMb();
    }
}
