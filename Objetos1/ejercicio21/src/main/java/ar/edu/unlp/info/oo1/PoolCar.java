package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoolCar {
    private List<Conductor> conductores;
    private List<Pasajero> pasajeros;

    private List<Viaje> viajes;

    public PoolCar(){
        this.conductores = new ArrayList<>();
        this.pasajeros = new ArrayList<>();
        this.viajes = new ArrayList<>();

    }

    public Conductor agregarConductor(String nombre, Vehiculo v){
        Conductor c = new Conductor(nombre, v);
        this.conductores.add(c);
        return c;
    }

    public Pasajero agregarPasajero (String nombre){
        Pasajero p = new Pasajero(nombre);
        this.pasajeros.add(p);
        return p;
    }

    public void cargarSaldo(Usuario u, double monto){
        u.incrementarSaldo(monto);
    }

    public Viaje agregarViaje (String origen, String destino, double costo, Vehiculo v, LocalDate fecha){
        Viaje v1 = new Viaje(v, origen, destino, costo, fecha);
        this.viajes.add(v1);
        return v1;
    }

    public List<Viaje> listarViajes(){
        return this.viajes.stream().filter(v-> v.getFecha().isEqual(LocalDate.now().plusDays(1))).collect(Collectors.toList());
    }

    public void procesarViajes(){
        listarViajes().stream().forEach(Viaje::procesar);
    }


    public List<Usuario> retornarUsuariosRegistrados(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(pasajeros);
        usuarios.addAll(conductores);
        return usuarios;
    }


    public void cargarMontoRegalo(double monto){
        this.retornarUsuariosRegistrados().stream().forEach(u-> u.incrementarSaldo(monto));

    }

    public void registrarPasajero(Pasajero p, Viaje v){
        if (v.tieneCapacidad()){
            v.agregarPasajero(p);
            p.agregarViaje(v);
        }
    }
}
