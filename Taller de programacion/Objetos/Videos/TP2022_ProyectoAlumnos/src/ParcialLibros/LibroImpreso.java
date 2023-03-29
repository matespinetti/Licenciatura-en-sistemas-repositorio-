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
public class LibroImpreso extends Libro {
    private boolean tapaDura;

    public LibroImpreso(boolean tapaDura, String titulo, double precioBase) {
        super(titulo, precioBase);
        this.tapaDura = tapaDura;
    }

    public boolean isTapaDura() {
        return tapaDura;
    }

    public void setTapaDura(boolean tapaDura) {
        this.tapaDura = tapaDura;
    }
    
    public double obtenerPrecioFinal () {
        double precioFinal = this.getPrecioBase();
        if (this.isTapaDura()) 
            precioFinal += 500;
        
        return precioFinal;
    }
}
