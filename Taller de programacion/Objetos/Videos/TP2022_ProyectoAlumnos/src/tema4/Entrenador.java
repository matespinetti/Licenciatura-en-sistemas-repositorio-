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
public class Entrenador extends Empleado {
    private int campeonatosGanados;

    public Entrenador( String nombre, Double sueldo, int Antiguedad, int campeonatosGanados) {
        super(nombre, sueldo, Antiguedad);
        this.campeonatosGanados = campeonatosGanados;
    }

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    
    public double calcularEfectividad () {
        return (double)this.getCampeonatosGanados() / this.getAntiguedad();
    }
    
    public double calcularSueldo () {
        double aux = super.calcularSueldo();
        if ((this.getCampeonatosGanados() >= 1) && (this.getCampeonatosGanados () <= 4))
            aux += 5000;
        else if ((this.getCampeonatosGanados() >= 5) && (this.getCampeonatosGanados () <= 10))
            aux += 30000;
        else if (this.getCampeonatosGanados() >= 10)
            aux += 50000;
        
        return aux;           
                    
       
    }
}
