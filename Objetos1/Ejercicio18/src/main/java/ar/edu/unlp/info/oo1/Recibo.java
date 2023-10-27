package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class Recibo {
    private String nombre;
    private String apellido;
    private int CUIL;
    private int antiguedad;
    private LocalDate fechaGeneracion;

    private double montoTotal;

    public Recibo(String nombre, String apellido, int CUIL, int antiguedad, LocalDate fechaGeneracion, double montoTotal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CUIL = CUIL;
        this.antiguedad = antiguedad;
        this.fechaGeneracion = fechaGeneracion;
        this.montoTotal = montoTotal;
    }
}
