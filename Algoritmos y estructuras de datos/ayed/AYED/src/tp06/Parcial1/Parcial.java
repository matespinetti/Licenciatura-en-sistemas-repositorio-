package tp06.Parcial1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {
    public ListaGenerica<String> resolver (Grafo<Ciudad> ciudades, String origen, String destino ) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        boolean [] marca = new boolean[ciudades.listaDeVertices().tamanio() + 1];
        boolean encontre = false;

        ListaGenerica<Vertice<Ciudad>> listaVertices = ciudades.listaDeVertices();
        listaVertices.comenzar();
        while (!listaVertices.fin() && !encontre){
            Vertice<Ciudad> v = listaVertices.proximo();
            if (v.dato().getNombre().equals(origen)) {
                encontre = true;
                if (v.dato().getFase() != 1) {
                    dfs(v.getPosicion(), ciudades, marca, destino, camino);
                }
            }
        }


        return camino;

    }

    private boolean dfs ( int i, Grafo<Ciudad> ciudades, boolean[] marca, String destino, ListaGenerica<String> camino){
        boolean encontre = false;
        Vertice<Ciudad> v = ciudades.listaDeVertices().elemento(i);
        marca[i] = true;
        camino.agregarFinal(v.dato().getNombre());
        if (v.dato().getNombre().equals(destino)) {
            encontre = true;
        }
        else {
            ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin() && !encontre){
                Vertice<Ciudad> vDestino = ady.proximo().verticeDestino();
                if (!marca[vDestino.getPosicion()] && vDestino.dato().getFase() != 1) {
                    encontre = this.dfs(vDestino.getPosicion(), ciudades, marca, destino, camino);
                }


            }
        }
        if (!encontre){
            camino.eliminarEn(camino.tamanio());
        }

        marca[i] = false;

        return encontre;
    }

    public class Ciudad{
        private String nombre;
        private int fase;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getFase() {
            return fase;
        }

        public void setFase(int fase) {
            this.fase = fase;
        }
    }
}
