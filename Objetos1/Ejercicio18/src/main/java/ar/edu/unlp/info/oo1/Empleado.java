package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private String apellido;
    private int CUIL;
    private LocalDate fechaNacimiento;
    private boolean tieneHijos;
    private boolean tieneConyuge;

    private List<Contrato> contratos;

    public Empleado(String nombre, String apellido, int CUIL, LocalDate fechaNacimiento, boolean tieneHijos, boolean tieneConyuge) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CUIL = CUIL;
        this.fechaNacimiento = fechaNacimiento;
        this.tieneHijos = tieneHijos;
        this.tieneConyuge = tieneConyuge;
        this.contratos = new ArrayList<Contrato>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCUIL() {
        return CUIL;
    }

    public void setCUIL(int CUIL) {
        this.CUIL = CUIL;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isTieneHijos() {
        return tieneHijos;
    }

    public void setTieneHijos(boolean tieneHijos) {
        this.tieneHijos = tieneHijos;
    }

    public boolean isTieneConyuge() {
        return tieneConyuge;
    }

    public void setTieneConyuge(boolean tieneConyuge) {
        this.tieneConyuge = tieneConyuge;
    }
}
