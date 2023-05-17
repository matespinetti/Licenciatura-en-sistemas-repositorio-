package ConjuntoParciales.Ejercicio10;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
    public ListaGenerica<Integer> resolver (ArbolBinario<Integer> arbol) {
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        resolver(arbol, lista);
        return lista;

    }

    private int resolver (ArbolBinario<Integer> arbol,ListaGenerica<Integer> lista ){
        int cantIzq = 0;
        int cantDer = 0;
        if (!arbol.esVacio()) {

            if (arbol.tieneHijoIzquierdo()){
                cantIzq = resolver(arbol.getHijoIzquierdo(), lista) + 1;
            }
            if (arbol.tieneHijoDerecho()){
                cantDer = resolver(arbol.getHijoDerecho(), lista) + 1;

            }

            if (cantIzq == cantDer){
                lista.agregarFinal(arbol.getDato());
            }
        }

        return cantIzq + cantDer;
    }
}
