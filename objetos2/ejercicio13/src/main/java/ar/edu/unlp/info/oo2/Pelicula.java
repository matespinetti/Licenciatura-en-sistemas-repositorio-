package ar.edu.unlp.info.oo2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String titulo;
    private int anoEstreno;
    private List<Pelicula> peliculasSimilares;
    private double puntaje;

    public Pelicula(String titulo, double puntaje,  int anoEstreno) {
        this.titulo = titulo;
        this.anoEstreno = anoEstreno;
        this.peliculasSimilares = new ArrayList<>();
        this.puntaje = puntaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoEstreno() {
        return anoEstreno;
    }

    public void setAnoEstreno(int anoEstreno) {
        this.anoEstreno = anoEstreno;
    }

    public List<Pelicula> getPeliculasSimilares() {
        return peliculasSimilares;
    }

    public void setPeliculasSimilares(List<Pelicula> peliculasSimilares) {
        this.peliculasSimilares = peliculasSimilares;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public void agregarSimilar(Pelicula p){
        this.peliculasSimilares.add(p);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (getClass() != obj.getClass())){
            return false;
        }

            Pelicula p = (Pelicula) obj;
            return this.titulo.equals(p.getTitulo());

    }
}
