package ParcialCodigo;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Camino {
    public ListaGenerica<Character> devolverCamino(ArbolGeneral<ElementoArbol> arbol) {
        ListaGenerica<Character> lista = new ListaEnlazadaGenerica<Character>();
        devolverCamino(arbol, 1, lista);
        return lista;
    }

    private void devolverCamino (ArbolGeneral<ElementoArbol> arbol, int cantHijos, ListaGenerica<Character> lista){
        if (!arbol.esVacio()) {
            if (arbol.getDato().getValor() == cantHijos) {
                lista.agregarFinal(arbol.getDato().getCaracter());
            }
            ListaGenerica<ArbolGeneral<ElementoArbol>> hijos = arbol.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                devolverCamino(hijos.proximo(), hijos.tamanio(), lista);
            }
        }
        }
    }



