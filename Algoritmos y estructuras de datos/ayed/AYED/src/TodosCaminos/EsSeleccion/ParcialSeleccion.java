package TodosCaminos.EsSeleccion;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ParcialSeleccion {
    public boolean esDeSeleccion (ArbolGeneral<Integer> arbol) {
        boolean seguir = true;
         if (arbol.esVacio()) {
             return false;
         }
         else if (arbol.esHoja()){
             return true;
         } else {
             ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
             hijos.comenzar();
             int min = Integer.MAX_VALUE;
             while (!hijos.fin() && seguir) {
                 ArbolGeneral<Integer> hijo = hijos.proximo();
                 min = Math.min(hijo.getDato(), min);
                 seguir = esDeSeleccion(hijo);

             }
             if (seguir) {
                 seguir = (arbol.getDato() == min);
             }
         }


         return seguir;
    }
}
