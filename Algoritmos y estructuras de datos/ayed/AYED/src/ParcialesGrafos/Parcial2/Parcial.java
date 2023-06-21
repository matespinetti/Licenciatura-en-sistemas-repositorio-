package ParcialesGrafos.Parcial2;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
    public ListaGenerica<String> resolver (Grafo<String> ciudades, String origen, String destino, ListaGenerica<String> pasandoPor) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        boolean [] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
        ListaGenerica<Vertice<String>> listaVertices = ciudades.listaDeVertices();
        listaVertices.comenzar();
        while (!listaVertices.fin()){
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals(origen)){
                resolver(v.getPosicion(), ciudades, marca, destino, pasandoPor, camino, 0);
            }
        }

        return camino;
    }


    private boolean resolver (int i, Grafo<String> ciudades,  boolean [] marca ,String destino,ListaGenerica<String> pasandoPor, ListaGenerica<String> camino, int incluye) {
        marca[i] = true;
        Vertice<String> v = ciudades.vetice(i);
        boolean encontre = false;
        camino.agregarFinal(v.dato());
        if (v.dato().equals(destino) && (incluye == pasandoPor.tamanio())) {
            encontre = true;
        } else {
            if (pasandoPor.incluye(v.dato())){
                incluye++;
            }
            ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin() && !encontre){
                Vertice<String> vDestino = ady.proximo().verticeDestino();
                encontre = resolver (vDestino.getPosicion(), ciudades, marca, destino, pasandoPor, camino, incluye);
            }
            if (!encontre){
                camino.eliminarEn(camino.tamanio());
            }
        }

        marca[i] = false;

        return encontre;
    }
}
