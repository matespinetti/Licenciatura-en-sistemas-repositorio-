package tp06.Ejercicio6;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class VisitaOslo {
    public ListaGenerica<String> paseoEnBici (Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
        boolean [] marca = new boolean[lugares.listaDeVertices().tamanio() + 1];
        ListaGenerica<Vertice<String>> listaVertices = lugares.listaDeVertices();
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        listaVertices.comenzar();
        while (!listaVertices.fin()){
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals("Ayuntamiento")) {
                camino.agregarFinal("Ayuntamiento");
                boolean encontre = paseoEnBici(v.getPosicion(), lugares, marca, destino, maxTiempo, lugaresRestringidos, camino);
                if (!encontre){
                    camino.eliminar("Ayuntamiento");
                }
                break;
            }

        }


        return camino;


    }

    private boolean paseoEnBici (int i, Grafo<String> grafo, boolean[] marca, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos, ListaGenerica<String> camino){
        boolean encontre = false;
        Vertice<String> vDestino = null;
        int j = 0;
        int p = 0;

        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin() && (!encontre)){
            Arista<String> a = ady.proximo();
            vDestino = a.verticeDestino();
            j = vDestino.getPosicion();
            if ((!marca[j]) && (!lugaresRestringidos.incluye(vDestino.dato()))){
                p = a.peso();
                if (maxTiempo - p >= 0) {
                    camino.agregarFinal(vDestino.dato());
                    marca[j] = true;
                    if (vDestino.dato().equals(destino)){
                        encontre = true;
                    }
                    else{
                        encontre = this.paseoEnBici(j, grafo, marca, destino, maxTiempo-p, lugaresRestringidos, camino);
                    }

                    if (!encontre) {
                        camino.eliminarEn(camino.tamanio());
                    }

                    marca[j]= false;
                }
            }
        }
        return encontre;
    }
}
