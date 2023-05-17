package ConjuntoParciales.Gematria;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ProcesadorGematria {
    public int contar (ArbolGeneral<Integer> arbol, int valor) {
        int cant = 0;
        if (!arbol.esVacio()) {
            valor -= arbol.getDato();
            if (arbol.esHoja()) {
                if (valor == 0) {
                    cant++;
                }
            }
            else {
                ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    cant += contar (hijos.proximo(), valor);
                }
            }
        }

        return cant;
    }

}
