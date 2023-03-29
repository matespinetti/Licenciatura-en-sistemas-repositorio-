/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciallibros;

/**
 *
 * @author Mateo Spinetti
 */
public class Libro {
    private String titulo, nombrePrimerAutor;
    private double peso;

    public Libro(String titulo, String nombrePrimerAutor, double peso) {
        this.titulo = titulo;
        this.nombrePrimerAutor = nombrePrimerAutor;
        this.peso = peso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombrePrimerAutor() {
        return nombrePrimerAutor;
    }

    public void setNombrePrimerAutor(String nombrePrimerAutor) {
        this.nombrePrimerAutor = nombrePrimerAutor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String toString() {
        return "Titulo " + this.getTitulo() + " Nombre Primer Autor: " + this.getNombrePrimerAutor() + "Peso: " + this.getPeso();
    }
    
}
