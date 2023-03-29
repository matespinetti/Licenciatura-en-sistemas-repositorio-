/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2018poo;

/**
 *
 * @author Mateo Spinetti
 */
public class FuncionTeatro {
   private String titulo, fecha, hora;
   private Espectador [] [] sala;
   private int [] cantButacasPorFila;

    public FuncionTeatro(String titulo, String fecha, String hora) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = new Espectador [20] [10];
        this.cantButacasPorFila = new int [20];
        for (int i = 0; i < this.getCantButacasPorFila().length; i++) {
            this.cantButacasPorFila[i] = 0;
        }
    }
   
   

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Espectador[][] getSala() {
        return sala;
    }

    public void setSala(Espectador[][] sala) {
        this.sala = sala;
    }

    public int[] getCantButacasPorFila() {
        return cantButacasPorFila;
    }

    public void setCantButacasPorFila(int[] cantButacasPorFila) {
        this.cantButacasPorFila = cantButacasPorFila;
    }
   
    public boolean validarFila (int fila) {
        boolean aux = false;
        if ((fila >= 1) && (fila <= 20))
            aux = true;
        
        return aux;
    }
    
    public boolean hayButacaLibreEnFila (int fila) {
        boolean hay = false;
        int j = 0;
        while ((j < this.sala[fila-1].length)&& !(hay)) {
            if (this.getSala()[fila-1][j] == null) {
                hay = true;
            }
            j++;
            
        }
        
        return hay;
    }
    
    public int agregarEspectadorAFila (int fila, Espectador espectador) {
        boolean pude = false;
        int j = 0;
        int nButaca = -1;
        
        
        while ((j < this.getSala()[fila-1].length) && !(pude)) {
            if (this.getSala()[fila-1][j] == null) {
                pude = true;
                getSala()[fila-1][j] = espectador;
                this.getCantButacasPorFila()[fila-1]++;
                nButaca = j + 1;
                
                
            }
            
            j++;
        }
        
        
        return nButaca;
    }
    
    
    public int calcularButacasLibres () {
        int butacasLibres = 0;
        for (int i = 0; i < this.getCantButacasPorFila().length; i++) {
            butacasLibres += (10 - this.getCantButacasPorFila()[i]);
        }
        
        return butacasLibres;   
    }
    
    
    public double calcularEdadPromedio () {
        int cantEspectadores = 0;
        double edadPromedio = 0;
        
        for (int i = 0; i < this.getSala().length; i ++) {
            for (int j = 0; j < this.getSala()[i].length; j ++ ) {
                if (this.getSala()[i] [j] != null) {
                    edadPromedio += this.getSala()[i][j].getEdad();
                    cantEspectadores ++;
                }
            }
        }
        
        edadPromedio /= (double)cantEspectadores;
        
        return edadPromedio;
    }
    
    public boolean estaRegistradoEspectador (int dni) {
        boolean existe = false;
        int i = 0;
        
        while ((i < this.getSala().length) && !(existe)) {
            int j = 0;
            while ((j < this.getSala()[i].length) && !(existe)) {
                if ((this.getSala()[i][j] != null) && (this.getSala()[i][j].getDni() == dni ))
                    existe = true;
                j++;
            }
            
            i++;
        }
        
        return existe;
    }
   
}




