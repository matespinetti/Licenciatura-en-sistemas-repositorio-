package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Decodificador {
    private List<Pelicula> grillaPeliculas;
    private List<Pelicula> peliculasReproducidas;
    private EstrategiaSugerencia estrategiaSugerencia;

    public Decodificador() {
        this.grillaPeliculas = new ArrayList<>();
        this.peliculasReproducidas = new ArrayList<>();
    }

    public List<Pelicula> getPeliculasNoReproducidas(){
        return this.grillaPeliculas.stream().filter(p -> !peliculasReproducidas.contains(p)).collect(Collectors.toList());


    }

    public List<Pelicula> getGrillaPeliculas() {
        return grillaPeliculas;
    }

    public void setGrillaPeliculas(List<Pelicula> grillaPeliculas) {
        this.grillaPeliculas = grillaPeliculas;
    }

    public List<Pelicula> getPeliculasReproducidas() {
        return peliculasReproducidas;
    }

    public void setPeliculasReproducidas(List<Pelicula> peliculasReproducidas) {
        this.peliculasReproducidas = peliculasReproducidas;
    }
    public void setEstrategiaSugerencia(EstrategiaSugerencia estrategiaSugerencia){
        this.estrategiaSugerencia = estrategiaSugerencia;
    }


    public void agregarSimilar(Pelicula p, Pelicula similar){
        p.agregarSimilar(similar);
    }

    public void agregarPeliculaGrilla(Pelicula p){
        this.grillaPeliculas.add(p);
    }

    public void agregarPeliculaReproducida(Pelicula p){
        if (!this.peliculasReproducidas.contains(p)){
            this.peliculasReproducidas.add(p);
            if (!this.grillaPeliculas.contains(p)){
                this.grillaPeliculas.add(p);
            }
        }

    }

    public EstrategiaSugerencia getEstrategiaSugerencia() {
        return estrategiaSugerencia;
    }


    public List<Pelicula> sugerirPeliculas(){
        return this.estrategiaSugerencia.sugerirPeliculas(this);
    }

}
