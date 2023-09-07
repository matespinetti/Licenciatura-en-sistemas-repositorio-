package ParcialesGrafos.EjercicioPractica;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
    public ListaGenerica<ListaGenerica<String>> procesar (Grafo<String> grafo){
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
        ListaGenerica<ListaGenerica<String>> todosCaminos = new ListaEnlazadaGenerica<ListaGenerica<String>>();
        for (int i = 1; i<= grafo.listaDeVertices().tamanio(); i++) {
            if (!marca[i]){
                ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
                procesar(i, grafo, marca, 0, camino, todosCaminos);

            }
        }

        return todosCaminos;
    }


    private void procesar (int i, Grafo<String> grafo, boolean[] marca, int peso,ListaGenerica<String> camino ,ListaGenerica<ListaGenerica<String>> todosCaminos){
        marca [i] = true;
        Vertice<String> v = grafo.vetice(i);
        camino.agregarFinal(v.dato());
        if (peso == 10){
            todosCaminos.agregarFinal(camino.clonar());
        } else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> a = ady.proximo();
                if (a.peso() <= 10 && !marca[a.verticeDestino().getPosicion()]){
                    procesar(a.verticeDestino().getPosicion(), grafo, marca, peso + a.peso(), camino, todosCaminos);
                }
            }
        }

        marca[i] = false;
        camino.eliminarEn(camino.tamanio());
    }
}
