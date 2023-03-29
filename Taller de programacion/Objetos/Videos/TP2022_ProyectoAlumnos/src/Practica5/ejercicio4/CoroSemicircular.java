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
public class CoroSemicircular extends Coro {
    private Corista [] vectorCoristas;
    private int dimL;

    public CoroSemicircular(int cantCoristas, String nombre, Director director) {
        super(nombre, director);
        this.vectorCoristas = new Corista [cantCoristas];
        this.dimL = 0;
    }

    public Corista[] getVectorCoristas() {
        return vectorCoristas;
    }

    public void setVectorCoristas(Corista[] vectorCoristas) {
        this.vectorCoristas = vectorCoristas;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }
    
    public void agregarCorista(Corista corista) {
        if (this.dimL < this.vectorCoristas.length) {
            this.vectorCoristas[dimL] = corista;
            this.dimL++;
        }
    }
    
    public boolean estaLleno () {
        boolean aux = false;
        if (dimL == this.vectorCoristas.length)
            aux = true;
        return aux;
    }
    
    public boolean estaOrdenado () {
        boolean ordenado = true;
        int i = 0;
        int min = 32000;
        while ((i < this.getDimL()) && (ordenado)) {
            if (this.vectorCoristas[i].getTono() < min)
                    min = this.vectorCoristas[i].getTono();
            else
                ordenado = false;
            i++;
        }
        
        return ordenado;
    }
    
    
     public String toString() {
       String mensaje = super.toString();
        for (int i = 0; i < this.dimL; i++) {
            mensaje += this.vectorCoristas[i].toString() + "\n";
        }
        
        return mensaje;
        
        
    
    }
    
}
