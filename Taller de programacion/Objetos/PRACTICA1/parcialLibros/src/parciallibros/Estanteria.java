/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciallibros;

/**
 *
 * @author Mateo Spinetti
 */
public class Estanteria {
    private Estante [] estantes;

    public Estanteria(int cantEstantes, int cantLibros) {
        this.estantes = new Estante [cantEstantes];
        for (int i = 0; i< this.estantes.length; i ++) {
            this.getEstantes()[i] = new Estante (cantLibros);
        }
    }
    
    

    public Estante[] getEstantes() {
        return estantes;
    }

    public void setEstantes(Estante[] estantes) {
        this.estantes = estantes;
    }
    
    public void almacenarLibro (Libro libro, int nEstante) {
        this.getEstantes()[nEstante].regarLibro(libro);
        

        }
    
    
    
    public Libro sacarLibro (int nEstante, int nLugar) {
 
        Libro libroADevolver = this.getEstantes()[nEstante].getLibros()[nLugar];
        this.getEstantes()[nEstante].getLibros()[nLugar] = null;
        
        return libroADevolver;
        
        
    } 
    
    public int calcular () {
        double max = -1;
        int maxEstante = 0;
        for (int i = 0; i < this.estantes.length; i ++) {
            System.out.println(this.getEstantes()[i].calcularPesoEstante());
            if (this.getEstantes()[i].calcularPesoEstante() > max) {
                
                max = this.getEstantes()[i].calcularPesoEstante();
                maxEstante = i;
            }
        }
    
        return maxEstante;
    }
}
