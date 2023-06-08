package Parcialito;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ObjetoDevolver {
    ListaGenerica<ArbolBinario<Integer>> lista;
    int cantPares;

    public ListaGenerica<ArbolBinario<Integer>> getLista() {
        return lista;
    }

    public void setLista(ListaGenerica<ArbolBinario<Integer>> lista) {
        this.lista = lista;
    }

    public int getCantPares() {
        return cantPares;
    }

    public void setCantPares(int cantPares) {
        this.cantPares = cantPares;
    }
}
