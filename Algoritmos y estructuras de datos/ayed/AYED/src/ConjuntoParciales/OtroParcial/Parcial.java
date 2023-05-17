package ConjuntoParciales.OtroParcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
    public ListaGenerica<Integer> resolver (ArbolBinario<Integer> arbol){
        ListaGenerica<Integer> listaDevolver = new ListaEnlazadaGenerica<>();
        if (!arbol.esVacio()){
            resolver(arbol, listaDevolver);
        }
        return listaDevolver;
    }

    private int resolver (ArbolBinario<Integer> arbol, ListaGenerica<Integer> listaDevolver) {
        if (arbol.esHoja()){
            listaDevolver.agregarFinal(arbol.getDato());
            return 1;
        }
        else {
            int cantIzq = 0;
            int cantDer = 0;
            if (arbol.tieneHijoIzquierdo()) {
                cantIzq = resolver(arbol.getHijoIzquierdo(), listaDevolver);
            }
            if (arbol.tieneHijoDerecho()){
                cantDer = resolver(arbol.getHijoDerecho(), listaDevolver);
            }

            if (cantIzq == cantDer){
                listaDevolver.agregarFinal(arbol.getDato());
            }

            return cantIzq + cantDer + 1;
        }
    }
}
