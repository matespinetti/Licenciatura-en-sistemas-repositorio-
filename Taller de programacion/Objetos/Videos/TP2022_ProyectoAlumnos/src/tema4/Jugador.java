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
public class Jugador extends Empleado {
    private int partidosJugados;
    private int goles;
    
    public Jugador (String nombre, double sueldo, int antiguedad, int partidosJugados, int goles){
        super(nombre, sueldo, antiguedad);
        this.partidosJugados = partidosJugados;
        this.goles = goles;
        
    }   

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    
    public double calcularEfectividad () {
        return ( (double)this.getGoles() / this.getPartidosJugados());
    
    }

    @Override
    public double calcularSueldo() {
       double aux = super.calcularSueldo();
       if (this.calcularEfectividad() > 0.5)
           aux += this.getSueldo();
       
       return aux;
    }
    
    
}
