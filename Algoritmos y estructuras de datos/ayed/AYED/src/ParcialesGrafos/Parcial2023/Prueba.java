package ParcialesGrafos.Parcial2023;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class Prueba {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<>("Mardel");
        Vertice<String> v3 = new VerticeImplListAdy<>("Pinamar");
        Vertice<String> v4 = new VerticeImplListAdy<>("La plata");
        Vertice<String> v5 = new VerticeImplListAdy<>("Gesell");
        Grafo<String> grafo = new GrafoImplListAdy<>();
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.conectar(v1, v5);
        grafo.conectar(v1, v2);
        grafo.conectar(v1, v3);
        grafo.conectar(v2, v5);
        grafo.conectar(v3, v5);
        grafo.conectar(v4, v5);
        grafo.conectar(v4, v1);
        grafo.conectar(v4, v3);
        ListaGenerica<String> nopasandoPor = new ListaEnlazadaGenerica<>();
        //pasandoPor.agregarFinal("Buenos Aires");
        nopasandoPor.agregarFinal("Mardel");
        Parcial p = new Parcial();
        ListaGenerica<ListaGenerica<String>> caminos = p.resolver(grafo, "Buenos Aires", "Gesell", nopasandoPor);

        caminos.comenzar();
        while (!caminos.fin()){
            ListaGenerica<String> camino = caminos.proximo();
            camino.comenzar();
            while (!camino.fin()){
                System.out.println(camino.proximo());
            }
            System.out.println();
        }
    }
}
