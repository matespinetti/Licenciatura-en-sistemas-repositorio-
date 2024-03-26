package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.List;

public class Pasajero extends Usuario {

    public List<Viaje> viajes;
    public Pasajero(String nombre) {
        super(nombre);
    }

    private boolean tieneViajeEnElPasado(){
        Viaje v1 = this.viajes.stream().filter(v-> v.getFecha().isBefore(LocalDate.now())).findFirst().orElse(null);
        return v1 != null;
    }

    @Override
    public void bonificar() {
        if (this.tieneViajeEnElPasado()){
            this.incrementarSaldo(500);
        }
    }


    public void agregarViaje (Viaje v){
        this.viajes.add(v);
    }
}
