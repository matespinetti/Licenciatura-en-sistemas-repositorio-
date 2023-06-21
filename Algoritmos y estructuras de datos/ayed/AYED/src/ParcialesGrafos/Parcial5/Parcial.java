package ParcialesGrafos.Parcial5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
    public ListaGenerica<Vertice<String>> resolver (Grafo<String> ciudad){
        ListaGenerica<Vertice<String>> camino = new ListaEnlazadaGenerica<>();
        boolean [] marca = new boolean[ciudad.listaDeVertices().tamanio() + 1];
        ListaGenerica<Vertice<String>> listaVertices = ciudad.listaDeVertices();
        listaVertices.comenzar();
        while (!listaVertices.fin()){
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals("Casa del Intendente")){
                resolver(v.getPosicion(), ciudad, marca, camino);
            }
        }

        return camino;
    }

    private boolean resolver (int i, Grafo<String> ciudad, boolean[] marca, ListaGenerica<Vertice<String>> camino){
        marca[i] = true;
        Vertice<String> v= ciudad.listaDeVertices().elemento(i);
        camino.agregarFinal(v);
        boolean encontre = false;
        if (v.dato().equals("Municipalidad")){
            encontre = true;
        }

        else if (!v.dato().equals("M")){
            ListaGenerica<Arista<String>> ady = ciudad.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> a = ady.proximo();
                Vertice<String> vDestino = a.verticeDestino();
                if (!marca[vDestino.getPosicion()] && a.peso() == 0){
                    encontre = resolver(vDestino.getPosicion(), ciudad, marca, camino);
                }

                if (!encontre){
                    camino.eliminarEn(camino.tamanio());
                }
            }
        }
        marca[i] = false;
        return encontre;

    }


}
