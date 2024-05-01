package ar.edu.unlp.info.oo2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaNovedad implements EstrategiaSugerencia {
    @Override
    public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
        return decodificador.getPeliculasNoReproducidas().stream().sorted(Comparator.comparing(Pelicula::getAnoEstreno).reversed()).limit(3).collect(Collectors.toList());
    }
}
