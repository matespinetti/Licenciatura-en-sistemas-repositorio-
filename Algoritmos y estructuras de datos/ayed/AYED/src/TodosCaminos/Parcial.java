package TodosCaminos;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
    public ListaGenerica<ListaGenerica<Integer>> todosCaminos(ArbolGeneral<Integer> ab) {
        ListaDevolver listaTotal = new ListaDevolver();
        ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<>();
        int altura = 0;
        if (!ab.esVacio()) {
            todosCaminos(ab, camino, listaTotal);
        }
        return listaTotal.getLista();
    }

    private void todosCaminos (ArbolGeneral<Integer> ab, ListaGenerica<Integer> camino, ListaDevolver listaTotal) {
        camino.agregarFinal(ab.getDato());
        if (ab.esHoja()) {
            if (camino.tamanio() > listaTotal.getAltura()) {
                listaTotal.setAltura(camino.tamanio());
                ListaGenerica<ListaGenerica<Integer>> listaNueva = new ListaEnlazadaGenerica<>();
                listaNueva.agregarFinal(camino.clonar());
                listaTotal.setLista(listaNueva);
            } else if (camino.tamanio() == listaTotal.getAltura()) {
                ListaGenerica<ListaGenerica<Integer>> aux = listaTotal.getLista();
                aux.agregarFinal(camino.clonar());
                listaTotal.setLista(aux);
            }

        } else {
            ListaGenerica<ArbolGeneral<Integer>> hijos = ab.getHijos();
            hijos.comenzar();
            while (!hijos.fin()){
                todosCaminos(hijos.proximo(), camino, listaTotal);
            }

        }

        camino.eliminarEn(camino.tamanio());


    }

    private class ListaDevolver {
        private int altura = 0;
        private ListaGenerica<ListaGenerica<Integer>> lista = new ListaEnlazadaGenerica<>();

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public ListaGenerica<ListaGenerica<Integer>> getLista() {
            return lista;
        }

        public void setLista(ListaGenerica<ListaGenerica<Integer>> lista) {
            this.lista = lista;
        }
    }
}
