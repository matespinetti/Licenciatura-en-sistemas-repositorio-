package tp04.Ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
    public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol) {
        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
        cola.encolar(arbol);
        cola.encolar(null);
        int suma = 0;
        int cant = 0;
        int prom = 0;
        int maxProm = Integer.MIN_VALUE;
        while (!cola.esVacia()) {
            arbol = cola.desencolar();
            if (arbol != null) {
                cant++;
                suma += arbol.getDato().getTransmicion();
                if (arbol.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = arbol.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                prom = suma / cant;
                if (prom > maxProm) {
                    maxProm = prom;
                }

                cant = 0;
                suma = 0;


            } else {
                prom = suma / cant;
                if (prom > maxProm) {
                    maxProm = prom;
                }

            }
        }
        return maxProm;
    }
}
