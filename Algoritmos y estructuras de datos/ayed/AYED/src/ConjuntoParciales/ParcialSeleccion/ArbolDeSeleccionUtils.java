package ConjuntoParciales.ParcialSeleccion;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ArbolDeSeleccionUtils {
    public boolean esDeSeleccion (ArbolGeneral<Integer> arbol) {
        Elemento elem = new Elemento(true);
        esDeSeleccion(arbol, elem);
        return elem.isEs();
    }



    public int esDeSeleccion (ArbolGeneral<Integer> arbol, Elemento elem) {
        if (!arbol.esVacio() && (elem.isEs())) {
            int minHijo = Integer.MAX_VALUE;
            int valor;
            ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                valor = esDeSeleccion(hijos.proximo(), elem);
                if (valor < minHijo) {
                    minHijo = valor;
                }
            }
            if (minHijo != arbol.getDato() && (!arbol.esHoja())) {
                elem.setEs(false);
            }
        }
        return arbol.getDato();
    }
}
