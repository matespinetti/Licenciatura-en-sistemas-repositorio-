package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion{
    private LocalDate fechaDeConstitucion;
    private double montoDepositado;

    private double porcentajeDeInteresDiario;

    public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
        this.fechaDeConstitucion = fechaDeConstitucion;
        this.montoDepositado = montoDepositado;
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
    }

    @Override
    public double valorActual() {
        System.out.println(ChronoUnit.DAYS.between(fechaDeConstitucion, LocalDate.now()));
        double valor = montoDepositado * Math.pow((1 + porcentajeDeInteresDiario), ChronoUnit.DAYS.between(fechaDeConstitucion, LocalDate.now()));
        return Math.floor(valor * 100) / 100;
    }

    public LocalDate getFechaDeConstitucion() {
        return fechaDeConstitucion;
    }

    public void setFechaDeConstitucion(LocalDate fechaDeConstitucion) {
        this.fechaDeConstitucion = fechaDeConstitucion;
    }

    public double getMontoDepositado() {
        return montoDepositado;
    }

    public void setMontoDepositado(double montoDepositado) {
        this.montoDepositado = montoDepositado;
    }

    public double getPorcentajeDeInteresDiario() {
        return porcentajeDeInteresDiario;
    }

    public void setPorcentajeDeInteresDiario(double porcentajeDeInteresDiario) {
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
    }
}
