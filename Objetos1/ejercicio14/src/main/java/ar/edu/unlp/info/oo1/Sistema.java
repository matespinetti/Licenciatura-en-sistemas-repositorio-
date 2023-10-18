package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
    private List<Usuario> usuarios;
    private List<Propiedad> propiedades;


    public void registrarUsuario(String nombre, String direccion, int dni){
        Usuario u = new Usuario(nombre, direccion, dni);
        usuarios.add(u);
    }

    public Propiedad registrarPropiedad(String nombre, String descripcion, double precioPorNoche, String direccion, Usuario propietario){
        Propiedad p = new Propiedad(nombre, descripcion, precioPorNoche, direccion, propietario);
        propiedades.add(p);
        propietario.agregarPropiedad(p);
        return p;
    }

    public List<Propiedad> buscarPropiedades(LocalDate desde, LocalDate hasta){
        return this.propiedades.stream().filter(propiedad -> propiedad.estaDisponible(desde, hasta)).collect(Collectors.toList());

    }


    public Reserva hacerUnaReserva(Propiedad propiedad, LocalDate desde, LocalDate hasta, Usuario inquilino){
        if (propiedad.estaDisponible(desde, hasta)){
            Reserva reserva = new Reserva(propiedad, new DateLapse(desde, hasta), inquilino);
            propiedad.agregarReserva(reserva);
            inquilino.agregarReserva(reserva);
            return reserva;
        }

        return null;

    }

    public void eliminarReserva(Reserva r){
        if (r.getPeriodo().getFrom().isAfter(LocalDate.now())){
            r.getInquilino().eliminarReserva(r);
            r.getPropiedad().eliminarReserva(r);
        }


    }

    public List<Reserva> obtenerReservasUsuario(Usuario u){
        return u.getReservas();

    }

    public double calcularIngresosPropietario(Usuario u, LocalDate desde, LocalDate hasta){
        u.getReservas().stream().filter(reserva -> reserva.colisiona(desde, hasta)).collect(Collectors.toList());
    }


}
