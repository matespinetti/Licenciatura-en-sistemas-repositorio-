package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private String nombre;
    private String direccion;

    private Long numeroTelefono;

    private List<Llamada> llamadas;


    public Cliente(String nombre, String direccion, Long numeroTelefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
        this.llamadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(Long numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public List<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    public void agregarLlamada(Llamada l){
        this.llamadas.add(l);

    }

    public Factura facturarLlamadas(LocalDate fechaInicio, LocalDate fechaFin){
        double montoTotal = this.llamadas.stream().filter(llamada -> llamada.estaEntreFechas(fechaInicio, fechaFin)).mapToDouble(Llamada::calcularCosto).sum();
        return new Factura(this, LocalDate.now(), fechaInicio, fechaFin, montoTotal);

    }
}
