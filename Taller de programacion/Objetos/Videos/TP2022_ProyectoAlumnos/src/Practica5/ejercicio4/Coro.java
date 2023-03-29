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
public abstract class Coro {
    private String nombre;
    private Director director;

    public Coro(String nombre, Director director) {
        this.nombre = nombre;
        this.director = director;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
   
    public abstract void agregarCorista(Corista corista);
    
    public abstract boolean estaLleno();
    
    public String toString() {
         String mensaje = "Nombre Coro: " + this.getNombre() + "Director: " + this.getDirector().toString() + "Coristas: ";
         return mensaje;
    }
    
}
