package ConjuntoParciales.CaminoMenosCostoso;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class CaminoMenosCostoso {
    ArbolBinario<Integer> arbol;

    public ArbolBinario<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ListaGenerica<Integer> caminoMenosCostosoAHojaMasLejana() {
        ListaGenerica<Integer> caminoAct = new ListaEnlazadaGenerica<>();
        ListaDevolver listaDevolver = new ListaDevolver();
        int coste = 0;
        if (!arbol.esVacio()){
            caminoMenosCostosoAHojaMasLejana(arbol, caminoAct, listaDevolver, coste);
        }

        return listaDevolver.getLista();
    }

    public void caminoMenosCostosoAHojaMasLejana(ArbolBinario<Integer> a, ListaGenerica<Integer> camino ,ListaDevolver listaDevolver, int coste) {
        camino.agregarFinal(a.getDato());
        coste += a.getDato();
        if (a.esHoja()) {
            ListaGenerica<Integer> listaD = listaDevolver.getLista();
            if ((camino.tamanio() > listaD.tamanio()) || ((camino.tamanio() == listaD.tamanio() && coste < listaDevolver.getSuma()))) {
                listaDevolver.setLista(camino.clonar());
                listaDevolver.setSuma(coste);
            }
        } else {
            if (a.tieneHijoIzquierdo()) {
                caminoMenosCostosoAHojaMasLejana(a.getHijoIzquierdo(), camino, listaDevolver, coste);
            }
            if (a.tieneHijoDerecho()){
                caminoMenosCostosoAHojaMasLejana(a.getHijoDerecho(), camino, listaDevolver, coste);
            }
        }

        camino.eliminarEn(camino.tamanio());
    }

    private class ListaDevolver {
        private ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        private int suma = Integer.MAX_VALUE;
        public ListaGenerica<Integer> getLista() {
            return lista;
        }

        public void setLista(ListaGenerica<Integer> lista) {
            this.lista = lista;
        }

        public int getSuma() {
            return suma;
        }

        public void setSuma(int suma) {
            this.suma = suma;
        }
    }

}
