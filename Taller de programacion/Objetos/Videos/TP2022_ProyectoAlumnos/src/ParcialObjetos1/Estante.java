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
public class Estante {
    private Libro [] estante;

    public Estante(int cantEstantes) {
        this.estante = new Libro [cantEstantes];
    }

    public Libro[] getEstante() {
        return estante;
    }

    public void setEstante(Libro[] estante) {
        this.estante = estante;
    }
    
   
        
        
    
}
