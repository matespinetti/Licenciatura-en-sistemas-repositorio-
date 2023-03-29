/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Mateo Spinetti
 */

    public class VisorFiguras {
        private int guardadas;
        private int capacidadMaxima = 5;
        private Figura [] vector;
        
        public VisorFiguras() {
            this.guardadas = 0;
            this.vector = new Figura[this.capacidadMaxima];
         
        }

    public int getGuardadas() {
        return guardadas;
    }

    public void setGuardadas(int guardadas) {
        this.guardadas = guardadas;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Figura[] getVector() {
        return vector;
    }

    public void setVector(Figura[] vector) {
        this.vector = vector;
    }
        
        
        public void guardar (Figura f) {
            vector [this.guardadas] = f;
            this.guardadas ++;
            
        }
        
        
        public boolean quedaEspacio () {
            boolean aux = true;
            if (this.getGuardadas() >= 5)
                aux = false;
        
            return aux;
        }
        
        
        public void mostrar () {
            for (int i = 0; i < this.getGuardadas(); i++) {
                System.out.println (vector[i]);
            }
        }

        
    }

