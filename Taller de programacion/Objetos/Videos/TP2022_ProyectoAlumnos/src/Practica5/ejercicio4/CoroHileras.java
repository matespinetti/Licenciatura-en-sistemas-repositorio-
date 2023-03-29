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
public class CoroHileras extends Coro {
    private Corista [] [] matrizCoristas;
    private int dimL;

    public CoroHileras(int cantFilas, int cantColumnas, String nombre, Director director) {
        super(nombre, director);
        this.matrizCoristas = new Corista [cantFilas] [cantColumnas];
        this.dimL = 0;
    }

    public Corista[][] getMatrizCoristas() {
        return matrizCoristas;
    }

    public void setMatrizCoristas(Corista[][] matrizCoristas) {
        this.matrizCoristas = matrizCoristas;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }
    
    public void agregarCorista(Corista corista) {
        if (dimL + 1 < this.matrizCoristas[0].length * this.matrizCoristas.length) {
            dimL++;
            int fila = this.getDimL() / this.matrizCoristas.length;
            int columna = this.getDimL() % this.matrizCoristas[0].length;
            this.matrizCoristas [fila] [columna] = corista;
        }        
        else
            System.out.println("No hay mas lugar para coristas");
            
        
        
    }
    
    public boolean estaLleno() {
        boolean aux = false;
        
        if (this.dimL == this.matrizCoristas[0].length * this.matrizCoristas.length)
            aux = true;
        
        return aux;
    }
    
    
    public boolean estaOrdenado() {
  
        int i = 0;
        boolean ordenado = true;
        int min = 32042;

        int tonoActualHilera = -1;
        while ((i < this.matrizCoristas.length ) && (ordenado)) {
            int j = 0;
            if (this.matrizCoristas[i][j] != null)
                 tonoActualHilera = this.matrizCoristas[i][j].getTono();
            if (tonoActualHilera < min)
                min = tonoActualHilera;
            else
                ordenado = false;
                        
            while ((j < this.matrizCoristas[i].length) && (ordenado)) {
                if ((this.matrizCoristas[i][j] != null) &&(this.matrizCoristas[i][j].getTono() != tonoActualHilera))    
                    ordenado = false;
                j++;
               
            }
            
            i++;
        }
        
        return ordenado;
    }
    
    public String toString() {
        String mensaje = super.toString();
        
        for (int i = 0; i < this.matrizCoristas.length; i ++) {
            for (int j = 0; j < this.matrizCoristas[i].length; j ++) {
                if (this.matrizCoristas[i][j] != null) {
                    mensaje += this.matrizCoristas[i][j].toString() + "\n";
                }
            }
        
        }
        
        return mensaje;
    }
   
}
