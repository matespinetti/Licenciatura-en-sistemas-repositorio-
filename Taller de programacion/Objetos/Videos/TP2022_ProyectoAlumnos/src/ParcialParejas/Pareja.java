/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialParejas;

/**
 *
 * @author Mateo Spinetti
 */
public class Pareja {

    private Participante[] participantes;

    public Pareja() {
        this.participantes = new Participante[2];

    }

    public void setParticipantes(Participante[] participantes) {
        this.participantes = participantes;
    }

    public Participante[] getParticipantes() {
        return participantes;
    }

    public int getDiferenciaEdad() {
        int diferencia = 0;
        if ((this.getParticipantes() != null) && (this.getParticipantes()[0] != null) && (this.getParticipantes()[1] != null)) {
            if (this.getParticipantes()[0].getEdad() >= this.getParticipantes()[1].getEdad()) {
                diferencia = this.getParticipantes()[0].getEdad() - this.getParticipantes()[1].getEdad();
            } else {
                diferencia = this.getParticipantes()[1].getEdad() - this.getParticipantes()[0].getEdad();
            }
        }
        
        return diferencia;
    }
}
