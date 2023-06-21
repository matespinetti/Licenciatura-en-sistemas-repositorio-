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
                devolverCaminoExceptuando(v.getPosicion(), mapaCiudades, marca, camino, ciudades, ciudad2);
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
        while ((!ady.fin()) && (!encontre) && (!prohibidos.incluye(v.dato()))) {
            int j = ady.proximo().verticeDestino().getPosicion();
            if (!marca[j]){
                encontre = devolverCaminoExceptuando(j, grafo, marca, camino, prohibidos, ciudad2);
            }
        }

        if (!encontre){
            camino.eliminarEn(camino.tamanio());
        }

        return encontre;
    }

    public ListaGenerica<String> caminoMasCorto (String ciudad1, String ciudad2){
        ListaGenerica<String> caminoAct = new ListaEnlazadaGenerica<>();
        ListaGenerica<String> caminoMasCorto = new ListaEnlazadaGenerica<>();
        boolean [] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
        ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
        listaVertices.comenzar();
        while (!listaVertices.fin()){
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals(ciudad1)) {
                marca[v.getPosicion()] = true;
                caminoMasCorto(v.getPosicion(), mapaCiudades, marca, caminoAct, caminoMasCorto, ciudad2);
                break;
            }
        }


        return caminoMasCorto;

    }

    private void caminoMasCorto (int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> caminoAct, ListaGenerica<String> caminoMasCorto, String ciudad2) {

        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        caminoAct.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            if ((caminoMasCorto.esVacia()) || (caminoAct.tamanio() < caminoMasCorto.tamanio())) {
                if (caminoAct.tamanio() < caminoMasCorto.tamanio()){
                    caminoMasCorto.comenzar();
                    while (!caminoMasCorto.fin()){
                        caminoMasCorto.eliminar(caminoMasCorto.proximo());
                    }
                }

                caminoMasCorto.comenzar();
                caminoAct.comenzar();
                while (!caminoAct.fin()){
                    caminoMasCorto.agregarFinal(caminoAct.proximo());
                }

            }

        }

        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()){
            int j = ady.proximo().verticeDestino().getPosicion();
            if (!marca[j]) {
                marca[j] = true;
                caminoMasCorto(j, grafo, marca, caminoAct, caminoMasCorto, ciudad2);
                marca [j] = false;
            }
        }

        caminoAct.eliminarEn(caminoAct.tamanio());
    }

    public ListaGenerica<String> caminoSinCargarCombustible (String ciudad1, String ciudad2, int tanqueAuto){
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        boolean [] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
        ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
        listaVertices.comenzar();
        while (!listaVertices.fin()){
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals(ciudad1)) {
                camino.agregarFinal(ciudad1);
                boolean encontre = caminoSinCargarCombustible(v.getPosicion(), mapaCiudades, marca, camino, tanqueAuto, ciudad2);
                if (!encontre){
                    camino.eliminar(ciudad1);
                }
            }
        }

        return camino;

    }

    private boolean caminoSinCargarCombustible (int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> camino, int tanque, String ciudad2){
        Vertice<String> vDestino = null;
        int p = 0;
        int j = 0;
        boolean encontre = false;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin() && !encontre){
            Arista<String> arista = ady.proximo();
            j = arista.verticeDestino().getPosicion();
            p = arista.peso();
            if (tanque - p >= 0) {
                vDestino = arista.verticeDestino();
                camino.agregarFinal(vDestino.dato());
                marca[j] = true;
                if (vDestino.dato().equals( ciudad2)) {
                    encontre = true;
                } else {
                    encontre = this.caminoSinCargarCombustible(j, grafo, marca, camino, tanque-p, ciudad2);
                }

                if (!encontre){
                    camino.eliminarEn(camino.tamanio());
                }
                marca[j] = false;

            }
        }

        return encontre;
    }

    public ListaGenerica<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        boolean [] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
        ListaGenerica<Vertice<String>> listaVertices = mapaCiudades.listaDeVertices();
        Elem elem = new Elem();
        listaVertices.comenzar();
        while (!listaVertices.fin()){
            Vertice<String> v = listaVertices.proximo();
            if (v.dato().equals(ciudad1)) {
                camino.agregarFinal(ciudad1);
                caminoConMenorCargaDeCombustible(v.getPosicion(), mapaCiudades, marca, camino, elem, tanqueAuto, tanqueAuto, 0, ciudad2 );
            }
        }

        return elem.getCaminoTotal();

    }

    private void caminoConMenorCargaDeCombustible (int i, Grafo<String> grafo, boolean [] marca, ListaGenerica<String> camino, Elem elem, int tanqueAct, int tanqueLleno, int cantCargado, String ciudad2){
        boolean encontre = false;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        Vertice<String> verticeDestino = null;
        int j = 0;
        int p = 0;
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin() && (!encontre)){
            Arista<String> arista = ady.proximo();
            verticeDestino = arista.verticeDestino();
            j = arista.verticeDestino().getPosicion();

            if (!marca[j]) {
                p = arista.peso();
                if (tanqueAct - p < 0) {
                    tanqueAct = tanqueLleno;
                    cantCargado ++;
                }

                if (tanqueAct - p >= 0) {

                    verticeDestino = arista.verticeDestino();
                    camino.agregarFinal(verticeDestino.dato());
                    marca[j] = true;
                    if (verticeDestino.dato().equals(ciudad2)) {
                        if (cantCargado < elem.getMaxCant()){
                            elem.setCaminoTotal(camino.clonar());
                            elem.setMaxCant(cantCargado);
                        }
                    } else {
                        this.caminoConMenorCargaDeCombustible(j, grafo, marca, camino, elem, tanqueAct - p, tanqueLleno, cantCargado, ciudad2);
                    }

                    camino.eliminarEn(camino.tamanio());


                    marca[j] = false;
                }

            }

        }
    }

    private class Elem {
        private ListaGenerica<String> caminoTotal = new ListaEnlazadaGenerica<String>();
        private int maxCant = Integer.MAX_VALUE;

        public ListaGenerica<String> getCaminoTotal() {
            return caminoTotal;
        }

        public void setCaminoTotal(ListaGenerica<String> caminoTotal) {
            this.caminoTotal = caminoTotal;
        }

        public int getMaxCant() {
            return maxCant;
        }

        public void setMaxCant(int maxCant) {
            this.maxCant = maxCant;
        }
    }
}



