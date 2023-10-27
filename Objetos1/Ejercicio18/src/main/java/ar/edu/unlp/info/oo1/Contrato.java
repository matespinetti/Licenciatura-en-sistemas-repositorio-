package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public abstract class Contrato {
    protected LocalDate fechaInicio;

    public Contrato(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public abstract double calcularMonto();
    public int calcularDuracion(){

    }


}
