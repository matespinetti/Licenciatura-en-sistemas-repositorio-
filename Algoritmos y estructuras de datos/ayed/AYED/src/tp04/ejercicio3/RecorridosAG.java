package tp04.ejercicio3;
import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG {



    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> l = new ListaEnlazadaGenerica<>();
        numerosImparesMayoresQuePreOrden(a, n, l);
        return l;

    }

    private void numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l) {
        if (!a.esVacio()) {
            if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
                l.agregarFinal(a.getDato());
            }

            if (a.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    numerosImparesMayoresQuePreOrden(hijos.proximo(), n, l);

                }


            }


        }


    }

    public ListaGenerica< Integer > numerosImparesMayoresQueInOrden (ArbolGeneral <Integer> a, Integer n) {
        ListaGenerica<Integer> l = new ListaEnlazadaGenerica<>();
        numerosImparesMayoresQueInOrden(a,n,l);
        return l;

    }

    private void numerosImparesMayoresQueInOrden (ArbolGeneral <Integer> a, Integer n, ListaGenerica< Integer > l) {
        if (!a.esVacio()) {
            ListaGenerica<ArbolGeneral<Integer>> hijos = null;
            if (a.tieneHijos()) {
                hijos = a.getHijos();
                if (!hijos.fin()) {
                    numerosImparesMayoresQueInOrden(hijos.proximo(), n, l);
                }

            }

            if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
                l.agregarFinal(a.getDato());
            }

            if (hijos != null) {
                while (!hijos.fin()) {
                    numerosImparesMayoresQueInOrden(hijos.proximo(), n, l);
                }
            }
        }
    }

    public ListaGenerica< Integer > numerosImparesMayoresQuePostOrden (ArbolGeneral <Integer> a, Integer n) {
        ListaGenerica<Integer> l = new ListaEnlazadaGenerica<>();
        numerosImparesMayoresQuePostOrden(a,n,l);
        return l;

    }

    private void numerosImparesMayoresQuePostOrden (ArbolGeneral <Integer> a, Integer n, ListaGenerica< Integer > l) {
        if (!a.esVacio()) {
            if (a.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                while (!hijos.fin()) {
                    numerosImparesMayoresQuePostOrden(hijos.proximo(), n, l);
                }

            }

            if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
                l.agregarFinal(a.getDato());
            }

        }
    }


    public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> listaReturn = new ListaEnlazadaGenerica<Integer>();
        ColaGenerica <ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
        cola.encolar(a);
        while (!cola.esVacia()) {
            a = cola.desencolar();
            if (a != null) {
                if ((a.getDato() % 2 == 1) || (a.getDato() > n)) {
                    listaReturn.agregarFinal(a.getDato());
                }
                if (a.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            }
        }

        return listaReturn;

    }


}
