package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
    private String nombre;
    private String descripcion;
    private double precioPorNoche;
    private String direccion;
    private Usuario propietario;

    private List<Reserva> reservas;

    public Propiedad(String nombre, String descripcion, double precioPorNoche, String direccion, Usuario propietario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorNoche = precioPorNoche;
        this.direccion = direccion;
        this.propietario = propietario;
        this.reservas = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean estaDisponible (LocalDate desde, LocalDate hasta){
        return reservas.stream().anyMatch(reserva -> reserva.colisiona(desde, hasta));
    }

    public void agregarReserva(Reserva r){
        reservas.add(r);

    }
    public void eliminarReserva(Reserva r){
        reservas.remove(r);
    }

}
