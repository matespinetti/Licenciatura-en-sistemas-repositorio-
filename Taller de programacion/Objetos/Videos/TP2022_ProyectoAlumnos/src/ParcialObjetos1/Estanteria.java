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
public class Estanteria {
    private Estante [] estantes;

    public Estanteria(int cantEstantes) {
        this.estantes = new Estante [cantEstantes];
    }

    public Estante[] getEstantes() {
        return estantes;
    }

    public void setEstantes(Estante[] estantes) {
        this.estantes = estantes;
    }
    
    public void almacenarLibro (Libro libro, int nEstante, int nLibro) {
        this.estantes[nEstante].getEstante()[nLibro] = libro;
    }
    
    public void sacarLibro (String titulo) {
        boolean encontre = false;
        int i = 0;
        Libro libroADevolver;
        while ((i < this.estantes.length) && !(encontre)) {
            int j = 0;
            while (j < this.estantes[i].getEstante().length) {
                if (this.estantes[i].getEstante()[j].getTitulo().equals(titulo)) {
                    encontre = true;
                    libroADevolver =this.estantes[i].getEstante()[j];
                    this.estantes[i].getEstante()[j] = null;
                    
                }
                j++;
            }
            
            i++;
        
        }
        
        
    }
    
    public void calcular () {
        double maxPeso = -1;
        Libro maxLibro;
        
        for (int i = 0; i < this.estantes.length; i++) {
            for (int j = 0; i < this.estantes[i].getEstante().length; i++) {
                if (this.estantes[i].getEstante() != null) {
                    if (this.estantes[i].getEstante()[j] != null) {
                        if (this.estantes[i].getEstante()[j].getPeso() > maxPeso){
                            maxPeso = this.estantes[i].getEstante()[j].getPeso();
                            maxLibro = this.estantes[i].getEstante()[j];
                        }
                            
                    }
                }
            }
        
        }
    
    }
    
    
    
}
