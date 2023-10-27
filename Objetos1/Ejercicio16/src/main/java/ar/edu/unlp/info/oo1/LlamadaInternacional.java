package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada {
    private String paisOrigen;

    private String paisDestino;

    public LlamadaInternacional(LocalDateTime comienzo, int duracion, Long telefonoLlama, Long telefonoReceptor, String paisOrigen, String paisDestino) {
        super(comienzo, duracion, telefonoLlama, telefonoReceptor);
        this.paisOrigen = paisOrigen;
        this.paisDestino = paisDestino;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    @Override
    public double calcularCosto() {
        double costoPorMinuto;
        LocalTime hora = comienzo.toLocalTime();
        if (hora.isAfter(LocalTime.of(8, 0)) && hora.isBefore(LocalTime.of(20,0))){
            costoPorMinuto = 4;
        } else {
            costoPorMinuto = 3;
        }
        return duracion * costoPorMinuto;
    }
}
