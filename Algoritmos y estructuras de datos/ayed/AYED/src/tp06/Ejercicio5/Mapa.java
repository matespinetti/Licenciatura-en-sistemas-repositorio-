package tp06.Ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Mapa {
    Grafo<String> mapaCiudades;

    public Mapa(Grafo<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    public ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2){
        boolean [] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();

        ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
        listaVertices.comenzar();
        while (!listaVertices.fin()) {
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals(ciudad1)) {
                devolverCamino(v.getPosicion(), mapaCiudades, marca, camino, ciudad2);
                break;
            }
        }

        return camino;

    }

    private boolean devolverCamino (int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> camino, String ciudad2){
        boolean encontre = false;
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        if (v.dato().equals(ciudad2)){
            encontre = true;
        }
        camino.agregarFinal(v.dato());
        ListaGenerica< Arista<String >> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin() && (!encontre)) {
            int j = ady.proximo().verticeDestino().getPosicion();
            if (!marca[j]) {
                encontre = this.devolverCamino(j, grafo, marca, camino, ciudad2);
            }

        }

        if (!encontre) {
            camino.eliminarEn(camino.tamanio());
        }



        return encontre;
    }


    public ListaGenerica<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, ListaGenerica<String> ciudades){
        boolean [] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
        listaVertices.comenzar();
        while (!listaVertices.fin()) {
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals(ciudad1)) {
                devolverCamino(v.getPosicion(), mapaCiudades, marca, camino, ciudad2);
                break;
            }
        }

        return camino;


    }

    private boolean devolverCaminoExceptuando (int i , Grafo<String> grafo, boolean[] marca, ListaGenerica<String> camino, ListaGenerica<String> prohibidos, String ciudad2){
        boolean encontre = false;
        marca [i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        camino.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            encontre = true;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin() && !encontre && !prohibidos.incluye(ciudad2)) {
            int j = ady.proximo().verticeDestino().getPosicion();
            if (!marca[j]){
                encontre = devolverCaminoExceptuando(j, grafo, marca, camino, prohibidos, ciudad2);
            }
        }

        if (!encontre){
            camino.eliminarEn(camino.tamanio());
        }
    }
}
