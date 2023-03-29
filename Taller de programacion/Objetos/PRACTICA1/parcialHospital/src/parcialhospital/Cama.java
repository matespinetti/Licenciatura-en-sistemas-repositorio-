/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialhospital;

/**
 *
 * @author Mateo Spinetti
 */
public class Cama {
    private int numero;
    private boolean ocupada = false;
    private Paciente paciente;
    private int cantDiasOcupada;

    public Cama(int numero, boolean ocupada, Paciente paciente, int cantDiasOcupada) {
        this.numero = numero;
        this.ocupada = ocupada;
        this.paciente = paciente;
        this.cantDiasOcupada = cantDiasOcupada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public int getCantDiasOcupada() {
        return cantDiasOcupada;
    }

    public void setCantDiasOcupada(int cantDiasOcupada) {
        this.cantDiasOcupada = cantDiasOcupada;
    }
    
    
    
}


