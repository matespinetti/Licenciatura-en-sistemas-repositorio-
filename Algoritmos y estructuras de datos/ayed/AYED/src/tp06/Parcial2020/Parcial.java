package tp06.Parcial2020;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Parcial {


    private class Ciudad{
        private String nombre;
        private int trafico;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getTrafico() {
            return trafico;
        }

        public void setTrafico(int trafico) {
            this.trafico = trafico;
        }
    }


    public ListaGenerica<String> resolver (Grafo<Ciudad> grafo, String destino, int maxControles){
        int pos = verificarOrigenDestino(grafo, "La plata", destino);
        ListaGenerica<String> caminoTotal = new ListaEnlazadaGenerica<>();
        if (pos != -1){
            boolean [] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
            ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<>();
            resolver(pos, grafo, destino, marca, maxControles, 0, -1, caminoActual, caminoTotal);
        }

        return caminoTotal;
    }

    private int resolver(int i,
                         Grafo<Ciudad> grafo,
                         String destino,
                         boolean[] marca,
                         int maxControles,
                         int tiempoActual,
                         int maxTiempo,
                         ListaGenerica<String> camino,
                         ListaGenerica<String> caminoTotal){


        marca[i] = true;
        Vertice<Ciudad> v = grafo.listaDeVertices().elemento(i);
        camino.agregarFinal(v.dato().getNombre());
        tiempoActual += v.dato().getTrafico();

        if (v.dato().getNombre().equals(destino)){
            if (tiempoActual > maxTiempo){
                maxTiempo = tiempoActual;
                caminoTotal = camino.clonar();
            }
        } else {
            ListaGenerica<Arista<Ciudad>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()){
                Arista<Ciudad> a = ady.proximo();
                if (!marca[a.verticeDestino().getPosicion()] && a.peso() <= maxControles){
                    maxTiempo = resolver(a.verticeDestino().getPosicion(), grafo, destino, marca, maxControles, tiempoActual, maxTiempo, camino, caminoTotal);
                }
            }
        }

        camino.eliminarEn(camino.tamanio());
        marca[i] = false;
        return maxTiempo;

    }

    private int verificarOrigenDestino(Grafo<Ciudad> grafo, String origen, String destino){
        int pos = -1;
        ListaGenerica<Vertice<Ciudad>> vertices = grafo.listaDeVertices();
        vertices.comenzar();
        boolean or = false;
        boolean des = false;

        while (!vertices.fin() && (!or | !des)){
            Vertice<Ciudad> v = vertices.proximo();
            if (v.dato().getNombre().equals(origen)){
                or = true;
                pos = v.getPosicion();
            }
            else if (v.dato().getNombre().equals(destino)){
                des = true;
            }
        }


        if (des && or){
            return pos;
        } else {
            return -1;
        }

    }

}
