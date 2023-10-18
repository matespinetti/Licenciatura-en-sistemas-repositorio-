package Parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
    public ListaGenerica<String> caminoMenor (Grafo<String> grafo, String ciudad1, String ciudad2, int tanqueAuto){
        int pos = buscarOrigenDestino(grafo, ciudad1, ciudad2);
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        if (pos != -1){
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
            ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();


        }
    }


    private int caminoMenor (int i , Grafo<String> grafo, boolean[] marca, int tanqueActual, int tanqueMax, int cantTanques, int maxTanques, ListaGenerica<String> caminoAct, ListaGenerica<String> caminoTotal, String ciudad2){
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        caminoAct.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)){
            if (cantTanques < maxTanques){
                maxTanques = cantTanques;
                caminoTotal = caminoAct.clonar();
            }
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()){
                boolean carge = false;
                Arista<String> a = ady.proximo();
                int peso = a.peso();
                if (!marca[a.verticeDestino().getPosicion()]) {
                    if (tanqueActual - peso < 0) {
                        tanqueActual = tanqueMax;
                        carge = true;
                    }

                    if (peso <= tanqueActual){
                        if (carge){
                            maxTanques = caminoMenor(a.verticeDestino().getPosicion(), grafo, marca, tanqueActual, maxTanques,  )
                        }
                    }
                }


            }
        }
    }

    public int buscarOrigenDestino(Grafo<String> grafo, String ciudad1, String ciudad2){
        boolean encontreO = false;
        boolean encontreD = false;
        int pos = -1;
        ListaGenerica<Vertice<String>> listaVertices = grafo.listaDeVertices();
        listaVertices.comenzar();
        while (!listaVertices.fin() && (!encontreD | encontreO)){
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals(ciudad1)){
                encontreO = true;
                pos = v.getPosicion();
            } else if (v.dato().equals(ciudad2)){
                encontreD = true;
            }
        }

        if (encontreO && encontreD){
            return pos;
        } else {
            return -1;
        }
    }
}
