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
public class Trabajador extends Persona {
    private String tareaRealizada;

    public Trabajador( String nombre, int dni, int edad, String tareaRealizada) {
        super(nombre, dni, edad);
        this.tareaRealizada = tareaRealizada;
    }

    public String getTareaRealizada() {
        return tareaRealizada;
    }

    public void setTareaRealizada(String tareaRealizada) {
        this.tareaRealizada = tareaRealizada;
    }

    @Override
    public String toString() {
        return super.toString() + ". Soy " + this.getTareaRealizada();
    }
    
    
      
}
