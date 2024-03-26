package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private Vehiculo vehiculo;
    private List<Usuario> pasajeros;

    private String origen;
    private String destino;
    private double costo;
    private LocalDate fecha;

    public Viaje(Vehiculo vehiculo,  String origen, String destino, double costo, LocalDate fecha) {
        this.vehiculo = vehiculo;
        this.pasajeros = new ArrayList<>();
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.fecha = fecha;
        this.pasajeros.add(this.vehiculo.getConductor());
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Usuario> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Usuario> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean tieneCapacidad(){
        return this.pasajeros.size() < this.vehiculo.getCapacidad();
    }

    public void agregarPasajero(Pasajero p){
        this.pasajeros.add(p);
    }

    public void procesar(){
        double costo = this.costo / this.pasajeros.size();
        this.pasajeros.stream().forEach(p-> {
            p.descontarSaldo(costo);
            p.bonificar();
        });

    }

}
