/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialteatro;

/**
 *
 * @author Mateo Spinetti
 */
public class Obra {
    private String nombre, nombreDirector;
    private Actor [] actores;   
    private int dimL;

    public Obra(String nombre, String nombreDirector) {
        this.nombre = nombre;
        this.nombreDirector = nombreDirector;
        this.actores = new Actor [100];
        this.dimL = 0;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public Actor[] getActores() {
        return actores;
    }

    public void setActores(Actor[] actores) {
        this.actores = actores;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }
    
    public void agregarActor (Actor actor) {
        if (dimL < this.getActores().length) {
            this.getActores()[dimL] = actor;
            this.setDimL(this.getDimL() + 1);
        }
    }
    
    
    
}
