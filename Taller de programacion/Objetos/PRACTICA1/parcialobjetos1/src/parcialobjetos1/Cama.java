/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialobjetos1;

/**
 *
 * @author Mateo Spinetti
 */
public class Cama {
   private int numero, cantDiasOcupada;
   private boolean ocupada;
   private Paciente paciente;

    public Cama(int numero, boolean ocupada) {
        this.numero = numero;
        this.ocupada = ocupada;
    }
   
   

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantDiasOcupada() {
        return cantDiasOcupada;
    }

    public void setCantDiasOcupada(int cantDiasOcupada) {
        this.cantDiasOcupada = cantDiasOcupada;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
   
   
}
