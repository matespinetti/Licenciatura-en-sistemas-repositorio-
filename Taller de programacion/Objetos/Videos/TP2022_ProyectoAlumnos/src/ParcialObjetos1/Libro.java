/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialObjetos1;

/**
 *
 * @author Mateo Spinetti
 */
public class Libro {
    private String titulo, nombreAutor;
    private double peso;

    public Libro(String titulo, String nombreAutor, double peso) {
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.peso = peso;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
