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
public class Estante {
    private Libro [] libros;

    public Estante(int cantLibros) {
        this.libros = new Libro [cantLibros];
    }

    public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

 
    
    public void regarLibro (Libro libro) {
        int i = 0;
        while ((i < this.libros.length) && (this.libros[i] != null)) {
            i++;
        }
        
        if (i < this.libros.length) {
            this.libros[i] = libro;
        }
        
            

    
    }
    public double calcularPesoEstante () {
        double peso = 0;
        for (int i = 0; i < this.libros.length; i++) {
                if (this.getLibros()[i] != null)
                    peso += this.getLibros()[i].getPeso();
        }
        
        
        return peso;
    }
   
    
    
    
    
}
