package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato{
    private LocalDate fechaFin;
    private double valorHora;
    private int horasPorMes;

    public ContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int horasPorMes) {
        super(fechaInicio);
        this.fechaFin = fechaFin;
        this.valorHora = valorHora;
        this.horasPorMes = horasPorMes;
    }

    public boolean estaVencido(){

    }

    public double calcularMonto(){

    }
}
