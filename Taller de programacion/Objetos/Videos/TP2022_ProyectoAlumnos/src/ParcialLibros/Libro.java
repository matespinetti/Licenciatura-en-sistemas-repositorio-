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
public abstract class Libro {
    private String titulo;
    private double precioBase;
    private String [] nombreAutores;
    private int dimL;

    public Libro(String titulo, double precioBase) {
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.nombreAutores = new String [8];
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String[] getNombreAutores() {
        return nombreAutores;
    }

    public void setNombreAutores(String[] nombreAutores) {
        this.nombreAutores = nombreAutores;
    }
    
    public void agregarAutor (String autor) {
        this.nombreAutores [dimL] = autor;
        dimL++;
    }
    
    public String toString() {
        String mensaje = "Titulo: " + this.getTitulo() + "Precio final: " + this.obtenerPrecioFinal() + "Nombre Autores: ";
        for (int i = 0; i < this.dimL; i ++) {
            mensaje += "Nombre: " + this.getNombreAutores()[i] + "\n";
        }
        
        return mensaje;
    }
    
    public abstract double obtenerPrecioFinal ();
    
    
    
    
    
    
    
}
