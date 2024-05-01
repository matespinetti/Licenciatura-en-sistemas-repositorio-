package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodificadorTest {
    Decodificador d1;
    Decodificador d2;
    Decodificador d3;
    Pelicula p1;
    Pelicula p2;
    Pelicula p3;
    Pelicula p4;
    Pelicula p5;
    Pelicula p6;
    Pelicula p7;
    @BeforeEach
    void setUp() throws Exception {
        d1 = new Decodificador();

        //El primer parametro es titulo, el segundo puntaje numero, el tercero el ano de estreno. NO LE PONGAS A TODAS EL MISMO PUNTAJE
        p1 = new Pelicula("Pelicula1", 1, 2000);
        p2 = new Pelicula("Pelicula2", 2, 2001);
        p3 = new Pelicula("Pelicula3", 3, 2002);
        p4 = new Pelicula("Pelicula4", 4, 2003);
        p5 = new Pelicula("Pelicula5", 5, 2004);
        p6 = new Pelicula("Pelicula6", 6, 2005);
        p7 = new Pelicula("Pelicula7", 7, 2006);
        p1.agregarSimilar(p5);
        p1.agregarSimilar(p3);
        p2.agregarSimilar(p3);
        p2.agregarSimilar(p4);
        d1.agregarPeliculaGrilla(p1);
        d1.agregarPeliculaGrilla(p2);
        d1.agregarPeliculaGrilla(p3);
        d1.agregarPeliculaGrilla(p4);
        d1.agregarPeliculaGrilla(p5);
        d1.agregarPeliculaGrilla(p6);
        d1.agregarPeliculaGrilla(p7);
        d1.agregarPeliculaReproducida(p1);
        d1.agregarPeliculaReproducida(p2);






    }

    @Test
    //Test sugerencia similaridad
    void testSugerenciaSimilaridad(){
        d1.setEstrategiaSugerencia(new SugerenciaSimilaridad());
        List<Pelicula> sugeridas = d1.sugerirPeliculas();
        for (Pelicula p: sugeridas){
            System.out.println(p.getTitulo());
        }
        boolean isSorted = sugeridas.stream().reduce((a,b) -> {
            if (a.getAnoEstreno() < b.getAnoEstreno()) {
                throw new RuntimeException("No esta ordenado");
            }
            return b;
        }).isPresent();
        assert(sugeridas.contains(p3));
        assert(sugeridas.contains(p4));
        assert(sugeridas.contains(p5));


    }

    @Test
    void testSugerenciaPuntaje(){
        d1.setEstrategiaSugerencia(new SugerenciaPuntaje());
        List<Pelicula> sugeridas = d1.sugerirPeliculas();
        for (Pelicula p: sugeridas){
            System.out.println(p.getTitulo());
        }
        assert(sugeridas.contains(p6));
        assert(sugeridas.contains(p7));
        assert(sugeridas.contains(p5));
    }


}
