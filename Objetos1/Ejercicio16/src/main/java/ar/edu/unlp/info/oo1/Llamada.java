package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Llamada {
    protected LocalDateTime comienzo;
    protected int duracion;

    protected Long telefonoLlama;

    protected Long telefonoReceptor;

    public Llamada(LocalDateTime comienzo, int duracion, Long telefonoLlama, Long telefonoReceptor) {
        this.comienzo = comienzo;
        this.duracion = duracion;
        this.telefonoLlama = telefonoLlama;
        this.telefonoReceptor = telefonoReceptor;
    }

    public LocalDateTime getComienzo() {
        return comienzo;
    }

    public void setComienzo(LocalDateTime comienzo) {
        this.comienzo = comienzo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Long getTelefonoLlama() {
        return telefonoLlama;
    }

    public void setTelefonoLlama(Long telefonoLlama) {
        this.telefonoLlama = telefonoLlama;
    }

    public Long getTelefonoReceptor() {
        return telefonoReceptor;
    }

    public void setTelefonoReceptor(Long telefonoReceptor) {
        this.telefonoReceptor = telefonoReceptor;
    }


    public abstract double calcularCosto();

    public boolean estaEntreFechas(LocalDate inicio, LocalDate fin){
        LocalDate fechaComienzo = this.comienzo.toLocalDate();

        return (fechaComienzo.isAfter(inicio) || fechaComienzo.isEqual(inicio)) && (fechaComienzo.isBefore(fin) ||  fechaComienzo.isEqual(fin));
    }
}
