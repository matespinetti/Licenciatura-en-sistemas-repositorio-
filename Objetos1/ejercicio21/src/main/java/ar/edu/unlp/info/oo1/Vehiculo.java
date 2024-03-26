package ar.edu.unlp.info.oo1;

import java.util.List;

public class Vehiculo {
    private Conductor conductor;

    private String descripcion;

    private int capacidad;

    private int anoFabricacion;

    private double valor;

    public Vehiculo(Conductor conductor, String descripcion, int capacidad, int anoFabricacion, double valor) {
        this.conductor = conductor;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.anoFabricacion = anoFabricacion;
        this.valor = valor;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean tieneCapacidad(int cant){
        return capacidad - cant >=0;
    }
}
