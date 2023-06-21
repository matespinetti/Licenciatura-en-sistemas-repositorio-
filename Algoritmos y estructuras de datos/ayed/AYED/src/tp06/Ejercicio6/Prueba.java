package tp06.Ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

import java.io.StringBufferInputStream;

public class Prueba {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<>("Catedral");
        Vertice<String> v2 = new VerticeImplListAdy<>("Estadio Unico");
        Vertice<String> v3 = new VerticeImplListAdy<>("Mac");
        Vertice<String> v4 = new VerticeImplListAdy<>("Facu");
        Vertice<String> v5 = new VerticeImplListAdy<>("Uno");
        Vertice<String> v6 = new VerticeImplListAdy<>("Ayuntamiento");

        Grafo<String> grafo = new GrafoImplListAdy<>();

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);

        grafo.conectar(v1, v2, 10);
        grafo.conectar(v2, v3, 10);
        grafo.conectar(v3, v4, 15);
        grafo.conectar(v4, v1, 15);
        grafo.conectar(v4, v5, 20);
        grafo.conectar(v5, v1, 30);
        grafo.conectar(v6, v1, 110);
        grafo.conectar(v6, v3, 12);

        VisitaOslo visita = new VisitaOslo();
        ListaGenerica<String> restringidos = new ListaEnlazadaGenerica<>();
        restringidos.agregarFinal("Uno");
        ListaGenerica<String> camino = visita.paseoEnBici(grafo, "Catedral", 100, restringidos);
        camino.comenzar();
        while (!camino.fin()){
            System.out.println(camino.proximo());
        }

    }

}
