package tp06.ejercicio4;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos<T> {
    public void dfs (Grafo<T> grafo) {
        boolean [] marca = new boolean [grafo.listaDeVertices().tamanio() + 1];
        for (int i = 1; i <= grafo.listaDeVertices().tamanio(); i++) {
            if (!marca[i]) {
                this.dfs(i, grafo, marca);
            }
        }
    }
    private void dfs(int i, Grafo<T> grafo, boolean[] marca) {
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        System.out.println(v);
        ListaGenerica<Arista<T>> listaAdyacentes = grafo.listaDeAdyacentes(v);
        listaAdyacentes.comenzar();
        while (!listaAdyacentes.fin()) {
            int j = listaAdyacentes.proximo().verticeDestino().getPosicion();
            if (!marca[j]) {
                this.dfs(j, grafo, marca);
            }
        }

    }


    // Orden (/v/ + /e/)


    public void bfs(Grafo<T> grafo){
        boolean [] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
        for (int i = 1; i<= marca.length; i++) {
            if (!marca[i]){
                bfs (i, grafo, marca);
            }
        }
    }


    private void bfs (int i, Grafo<T> grafo, boolean[] marca){
        marca[i] = true;
        ListaGenerica<Arista<T>> ady = null;
        ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
        cola.encolar(grafo.listaDeVertices().elemento(i));
        while (!cola.esVacia()){
            Vertice<T> v = cola.desencolar();
            System.out.println(v.dato());
            ady = grafo.listaDeAdyacentes(v);
            while (!ady.fin()){
                Arista<T> arista = ady.proximo();
                int j = arista.verticeDestino().getPosicion();
                if (!marca[j]) {
                    Vertice<T> w = arista.verticeDestino();
                    marca[j] = true;
                    cola.encolar(w);
                }
            }
        }
    }
}

/// O(/v/ + /e/)


