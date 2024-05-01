package ar.edu.unlp.info.oo2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPuntaje implements EstrategiaSugerencia {
    @Override
    public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
        for (Pelicula p: decodificador.getPeliculasNoReproducidas()){
            System.out.println("No reproducida: " + p.getTitulo());
        }
        return decodificador.getPeliculasNoReproducidas().stream().sorted((p1, p2) -> {
            int puntajeCompare = Double.compare(p2.getPuntaje(), p1.getPuntaje());
            if (puntajeCompare != 0){
                return puntajeCompare;
            } else {
                return Integer.compare(p2.getAnoEstreno(), p1.getAnoEstreno());
            }
        }).limit(3).collect(Collectors.toList());
    }
}
