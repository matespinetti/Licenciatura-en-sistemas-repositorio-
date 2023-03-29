/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Mateo Spinetti
 */
public class Estante {
    private Libro [] vectorL;
    private int dimL;

    public Estante() {
        vectorL = new Libro[20];
        dimL = 0;
    }
    
    public void addLibro (Libro l1) {
        vectorL [dimL] = l1;
        dimL += 1;
    }
    public int getCantLibros () {
        return dimL;
    }
    
    public boolean estaLleno () {
        boolean lleno;
        if (dimL == 20) 
            lleno = true;
        else
            lleno = false;
        
        return lleno;
                   
    }
    
    public Libro devolverLibro (String titulo) {
        int i = 0;
        Libro libroAct = null;
        boolean encontre = false;
        while ((i < dimL) && !(encontre)){
            if (vectorL[i].getTitulo().equals(titulo)) {
                libroAct = vectorL[i];
                encontre = true;
            }
            i++;
        }
        
        return libroAct;
 
    }
    
    
}
