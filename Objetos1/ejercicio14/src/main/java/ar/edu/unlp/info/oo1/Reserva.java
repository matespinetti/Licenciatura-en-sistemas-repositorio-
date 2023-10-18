package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.Date;

public class Reserva {
    private Propiedad propiedad;
    private DateLapse periodo;
    private Usuario inquilino;

    public Reserva(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
        this.propiedad = propiedad;
        this.periodo = periodo;
        this.inquilino = inquilino;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public DateLapse getPeriodo() {
        return periodo;
    }

    public void setPeriodo(DateLapse periodo) {
        this.periodo = periodo;
    }

    public Usuario getInquilino() {
        return inquilino;
    }

    public void setInquilino(Usuario inquilino) {
        this.inquilino = inquilino;
    }

    public boolean colisiona (LocalDate desde, LocalDate hasta){
        return (desde.isBefore(periodo.getTo()) || desde.isEqual(periodo.getTo()))
                && (hasta.isAfter(periodo.getFrom()) || hasta.isEqual(periodo.getTo()));
    }

    public double calcularPrecio(){
        return propiedad.getPrecioPorNoche() * this.periodo.sizeInDays();

    }
}
