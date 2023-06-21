package ParcialesGrafos.Parcial2023;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
    public ListaGenerica<ListaGenerica<String>> resolver (Grafo<String> ciudades, String origen, String destino, ListaGenerica<String> evitarPasandoPor){
        ListaGenerica<ListaGenerica<String>> todosCaminos = new ListaEnlazadaGenerica<ListaGenerica<String>>();
        if (verificarDestinoOrigen(ciudades, origen, destino)){
            ListaGenerica<Vertice<String>> listaVertices = ciudades.listaDeVertices();
            boolean [] marca = new boolean[listaVertices.tamanio() + 1];
            ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
            listaVertices.comenzar();
            boolean encontre = false;
            while (!encontre){
                Vertice<String> v = listaVertices.proximo();
                if (v.dato().equals(origen)){
                    encontre = true;
                    resolver(v.getPosicion(), ciudades, marca, destino, evitarPasandoPor, camino, todosCaminos);

                }
            }


        }

        return  todosCaminos;
    }



    private void resolver (int i, Grafo<String> ciudades, boolean[] marca ,String destino, ListaGenerica<String> evitarPasandoPor, ListaGenerica<String> camino, ListaGenerica<ListaGenerica<String>> todosCaminos){
        marca[i] = true;
        Vertice<String> v = ciudades.listaDeVertices().elemento(i);
        camino.agregarFinal(v.dato());
        if (v.dato().equals(destino)){
            todosCaminos.agregarFinal(camino.clonar());
        }
        else if (!evitarPasandoPor.incluye(v.dato())) {
            ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()){
                Arista<String> a = ady.proximo();
                Vertice<String> vDestino = a.verticeDestino();
                if (!marca[vDestino.getPosicion()]){
                    resolver (vDestino.getPosicion(), ciudades, marca, destino, evitarPasandoPor, camino, todosCaminos);
                }
            }
        }
        camino.eliminarEn(camino.tamanio());
        marca[i] = false;
    }

    private boolean verificarDestinoOrigen(Grafo<String> ciudades, String origen, String destino){
        ListaGenerica<Vertice<String>> listaVertices = ciudades.listaDeVertices();
        listaVertices.comenzar();
        boolean existeO = false;
        boolean existeD = false;
        while (!listaVertices.fin() && (!existeD || !existeO)){
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals(origen)){
                existeO = true;
            } else if (v.dato().equals(destino)){
                existeD = true;
            }
        }

        return existeO && existeD;
    }
}
