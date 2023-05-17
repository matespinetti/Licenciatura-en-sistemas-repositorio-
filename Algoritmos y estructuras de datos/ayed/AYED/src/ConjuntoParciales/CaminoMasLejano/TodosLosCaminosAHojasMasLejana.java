package ConjuntoParciales.CaminoMasLejano;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class TodosLosCaminosAHojasMasLejana {
    ArbolBinario<Integer> arbol;



    public ArbolBinario<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ListaGenerica<ListaGenerica<Integer>> todosLosCaminosAHojasMasLejana() {
        CustomList listaDevolver = new CustomList();
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        todosLosCaminosAHojasMasLejana(arbol, lista, listaDevolver);

        return listaDevolver.getLista();


    }

private void todosLosCaminosAHojasMasLejana(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista, CustomList listaDevolver) {
        if (arbol.esHoja()) {
            ListaGenerica<ListaGenerica<Integer>> l2;
            lista.agregarFinal(arbol.getDato());
            if (lista.tamanio() > listaDevolver.getMaxProfundidad()) {
                listaDevolver.setMaxProfundidad(lista.tamanio());
                l2 = new ListaEnlazadaGenerica<ListaGenerica<Integer>>();
                l2.agregarFinal(lista);
                listaDevolver.setLista(l2);

            } else if (lista.tamanio() == listaDevolver.getMaxProfundidad()) {
                l2 = listaDevolver.getLista();
                l2.agregarFinal(lista);
                listaDevolver.setLista(l2);
            }

        } else   {

        lista.agregarFinal(arbol.getDato());
        ListaGenerica<Integer> listaIzq = lista.clonar();
        ListaGenerica<Integer> listaDer = lista.clonar();

        if (arbol.tieneHijoIzquierdo()) {
            todosLosCaminosAHojasMasLejana(arbol.getHijoIzquierdo(), listaIzq, listaDevolver);
        }

        if (arbol.tieneHijoDerecho()) {
            todosLosCaminosAHojasMasLejana(arbol.getHijoDerecho(), listaDer, listaDevolver);
        }

    }


    }

    private class CustomList {
        private int maxProfundidad = 0;
        private ListaGenerica<ListaGenerica<Integer>> lista = new ListaEnlazadaGenerica<ListaGenerica<Integer>>();

        public int getMaxProfundidad() {
            return maxProfundidad;
        }

        public void setMaxProfundidad(int maxProfundidad) {
            this.maxProfundidad = maxProfundidad;
        }

        public ListaGenerica<ListaGenerica<Integer>> getLista() {
            return lista;
        }

        public void setLista(ListaGenerica<ListaGenerica<Integer>> lista) {
            this.lista = lista;
        }
    }


}






