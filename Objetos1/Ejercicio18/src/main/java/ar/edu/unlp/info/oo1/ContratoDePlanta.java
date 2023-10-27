package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class ContratoDePlanta extends Contrato {

    private double sueldoMensual;
    private double montoConyuge;
    private double montoHijos;

    public ContratoDePlanta(LocalDate fechaInicio, double sueldoMensual, double montoConyuge, double montoHijos) {
        super(fechaInicio);
        this.sueldoMensual = sueldoMensual;
        this.montoConyuge = montoConyuge;
        this.montoHijos = montoHijos;
    }

    public double calcularMonto(){

    }

}
