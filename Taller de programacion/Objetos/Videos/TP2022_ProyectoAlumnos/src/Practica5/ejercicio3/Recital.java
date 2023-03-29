/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5.ejercicio3;

/**
 *
 * @author Mateo Spinetti
 */
public abstract class Recital {
    private String nombreBanda;
    private String [] listaTemas;
    private int dimL;

    public Recital(String nombreBanda, int cantTemas) {
        this.nombreBanda = nombreBanda;
        this.listaTemas = new String [cantTemas];
        this.dimL = 0;
    
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }
    

    
    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public String[] getListaTemas() {
        return listaTemas;
    }

    public void setListaTemas(String[] listaTemas) {
        this.listaTemas = listaTemas;
    }
    
    public void agregarTema (String tema) {
        if (dimL < this.getListaTemas().length) {
            this.listaTemas[dimL] = tema;
            dimL++;
        }
    } 
    
    public String toString () {
        String mensaje = "Y ahora tocaremos: ";
        String aux = "";
        for (int i = 0; i < this.dimL; i ++) {
            aux += mensaje + this.listaTemas[i] + ". \n";
        }
        
        return aux;
        
    }
    
    
    public void actuar () {
        System.out.println(this.toString());
    }
    
    public abstract double calcularCosto();
}

