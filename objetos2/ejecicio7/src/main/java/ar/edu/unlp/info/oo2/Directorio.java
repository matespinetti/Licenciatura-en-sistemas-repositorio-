package ar.edu.unlp.info.oo2;

import java.time.LocalDate;
import java.util.*;

public class Directorio extends Elemento{
    private List<Elemento> elementos;
    public Directorio(String nombre, LocalDate fechaCreacion) {
        super(nombre, fechaCreacion, 32);
        this.elementos = new ArrayList<>();

    }


    public List<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(List<Elemento> elementos) {
        this.elementos = elementos;
        this.tamanoBytes = 32 + elementos.stream().mapToDouble(Elemento::getTamanoBytes).sum();
    }

    public void addElemento(Elemento elemento){
        this.elementos.add(elemento);
        this.tamanoBytes += elemento.getTamanoBytes();
    }

    public void removeElemento(Elemento elemento){
        this.elementos.remove(elemento);
        this.tamanoBytes -= elemento.getTamanoBytes();
    }

    public Archivo archivoMasGrande(){
        if (this.elementos.isEmpty()){
            return null;
        }

        return this.elementos.stream().map(Elemento::archivoMasGrande).filter(Objects::nonNull).max(Comparator.comparing(Archivo::getTamanoBytes)).orElse(null);



    }

    public Archivo archivoMasNuevo(){
        if (this.elementos.isEmpty()){
            return null;
        }


        return this.elementos.stream().map(Elemento::archivoMasNuevo).filter(Objects::nonNull).max(Comparator.comparing(Archivo::getFechaCreacion)).orElse(null);
    }

    @Override
    public Elemento buscar(String nombre){
        if (this.nombre.equals(nombre)){
            return this;
        }
        else {
            return elementos.stream().map(e -> e.buscar(nombre)).filter(Objects::nonNull).findFirst().orElse(null);
        }
    }

    public List<Elemento> buscarTodos(String nombre){
        List<Elemento> l = new ArrayList<>();
        if (this.nombre.equals(nombre)){
            l.add(this);
        }

        List<Elemento> l2 = new ArrayList<>();
        this.elementos.stream().forEach(elemento -> {
            l2.addAll(elemento.buscarTodos(nombre));
        });

        l2.addAll(l);
        return l2;
    }

    public String listadoDeContenido(String path){
        String s = "";
        String pathActual = this.
        for (Elemento e: this.elementos
             ) {
            s += "\n";
            s += e.listadoDeContenido(s)


        }

        return s;
    }
}
