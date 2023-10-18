package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
    private String nombre;
    private List<Inversion> inversiones;


    public Inversor(String nombre) {
        this.nombre = nombre;
        this.inversiones = new ArrayList<>();
    }

    public double valorActual() {
        return inversiones.stream().mapToDouble(Inversion::valorActual).sum();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Inversion> getInversiones() {
        return inversiones;
    }

    public void setInversiones(List<Inversion> inversiones) {
        this.inversiones = inversiones;
    }

    public void agregarInversion(Inversion i){
        inversiones.add(i);
    }
}
