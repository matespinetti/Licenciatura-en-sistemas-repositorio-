package ar.edu.unlp.info.oo2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Archivo extends Elemento{
    public Archivo(String nombre, LocalDate fechaCreacion, double tamanoBytes) {
        super(nombre, fechaCreacion, tamanoBytes);
    }
    public Archivo(){}

    public Archivo archivoMasNuevo(){
        return this;
    }
    public Elemento buscar(String nombre) {
        if (this.nombre.equals(nombre)){
            return this;
        }

        return null;
    }

    public Archivo archivoMasGrande(){
        return this;
    }

    public List<Elemento> buscarTodos(String nombre){
        List<Elemento> l = new ArrayList<>();
        if (this.nombre.equals(nombre)){
            l.add(this);
        }
        return l;
    }

    public String listadoDeContenido(String path){
        return path + this.nombre;
    }
}
