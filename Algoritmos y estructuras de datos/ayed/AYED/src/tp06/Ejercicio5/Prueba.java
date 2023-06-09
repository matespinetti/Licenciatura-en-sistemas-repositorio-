package tp06.Ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class Prueba {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<>("Rio de janeiro");
        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.conectar(v1, v4, 17 );
        ciudades.conectar(v1, v3, 10);
        ciudades.conectar(v3, v4, 8);
        ciudades.conectar(v1, v2, 5);
        ciudades.conectar(v2, v4, 4);
        ciudades.conectar(v2, v3, 11);

        Mapa mapa = new Mapa(ciudades);
        ListaGenerica<String > prohibidos = new ListaEnlazadaGenerica<>();
        prohibidos.agregarFinal("Lima");
        ListaGenerica<String> camino = mapa.caminoConMenorCargaDeCombustible("Buenos Aires", "Rio de janeiro", 100);
        camino.comenzar();
        while (!camino.fin()){
            System.out.println(camino.proximo());
        }




    }
}
