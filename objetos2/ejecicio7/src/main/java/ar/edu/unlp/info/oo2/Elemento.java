package ar.edu.unlp.info.oo2;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public abstract class Elemento {
    protected String nombre;
    protected LocalDate fechaCreacion;

    protected double tamanoBytes;

    public Elemento(String nombre, LocalDate fechaCreacion, double tamanoBytes) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.tamanoBytes = tamanoBytes;
    }

    public Elemento(){}


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getTamanoBytes() {
        return tamanoBytes;
    }

    public void setTamanoBytes(double tamanoBytes) {
        this.tamanoBytes = tamanoBytes;
    }

    public abstract Archivo archivoMasNuevo();
    public abstract Archivo archivoMasGrande();
    public abstract Elemento buscar(String nombre);

    public abstract List<Elemento> buscarTodos(String nombre);

    public abstract String listadoDeContenido(String path);
}
