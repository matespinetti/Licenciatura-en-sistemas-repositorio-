/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialParejas;

/**
 *
 * @author Mateo Spinetti
 */
public class Concurso {
    private Pareja [] parejas;
    private int dimL;

    public Concurso(int dimF) {
        this.parejas = new Pareja [dimF];
    }

    public void setParejas(Pareja[] parejas) {
        this.parejas = parejas;
    }

    public Pareja[] getParejas() {
        return parejas;
    }
    
    public void agregarPareja (Pareja pareja) {
        this.parejas [dimL] = pareja;
        dimL++;
    }
    
    public Pareja maxDiferenciaEdad() {
        int maxDiferenciaEdad = -1;
        Pareja maxPareja = null;
        for (int i = 0; i < this.dimL; i++) {
            if (this.getParejas()[i].getDiferenciaEdad() > maxDiferenciaEdad){
                maxDiferenciaEdad = this.getParejas()[i].getDiferenciaEdad();
                maxPareja = this.getParejas()[i];
            }
        } 
        
        return maxPareja;
    }
}
