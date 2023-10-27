package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada{
    public LlamadaLocal(LocalDateTime comienzo, int duracion, Long telefonoLlama, Long telefonoReceptor) {
        super(comienzo, duracion, telefonoLlama, telefonoReceptor);
    }

    @Override
    public double calcularCosto() {
        return duracion;
    }
}
