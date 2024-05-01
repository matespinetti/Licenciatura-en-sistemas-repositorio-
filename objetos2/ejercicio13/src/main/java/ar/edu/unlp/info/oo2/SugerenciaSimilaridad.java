package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaSimilaridad implements EstrategiaSugerencia{
    @Override
    public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
       return decodificador.getPeliculasReproducidas().stream().map(Pelicula::getPeliculasSimilares).flatMap(List::stream).distinct().filter(p->!decodificador.getPeliculasReproducidas().contains(p)).sorted(Comparator.comparing(Pelicula::getAnoEstreno).reversed()).limit(3).collect(Collectors.toList());
    }
}
