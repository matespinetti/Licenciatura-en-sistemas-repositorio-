package ConjuntoParciales.CaminoAHojaMasLejana;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class CaminoAHojaMasLejana {
    public ListaGenerica<Integer> hojaMasLejana (ArbolGeneral<Integer> arbol) {
        ListaGenerica<Integer> listaAct = new ListaEnlazadaGenerica<Integer>();
        ListaDevolver listaDev = new ListaDevolver();
        if (!arbol.esVacio()) {
            hojaMasLejana(arbol, listaDev, listaAct);
        }

        return listaDev.getLista();
    }

    private void hojaMasLejana (ArbolGeneral<Integer> arbol, ListaDevolver listaDev, ListaGenerica<Integer> listaAct) {

        listaAct.agregarFinal(arbol.getDato());
        if (arbol.esHoja()) {
            if (listaAct.tamanio() > listaDev.getLista().tamanio()) {
                listaDev.setLista(listaAct.clonar());
            } else {
                listaAct.eliminarEn(listaAct.tamanio());
            }
        } else {
            ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                hojaMasLejana(hijos.proximo(), listaDev, listaAct);
                listaAct.eliminarEn(listaAct.tamanio());

            }



        }
    }

    private class ListaDevolver {
        private ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();

        public ListaGenerica<Integer> getLista() {
            return lista;
        }

        public void setLista(ListaGenerica<Integer> lista) {
            this.lista = lista;
        }
    }
}
