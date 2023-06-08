package ConjuntoParciales.Ejercicio3;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ej3 {

    public ArbolGeneral<Character> creciente(ArbolGeneral<Character> arbol){
        ColaGenerica<ArbolGeneral<Character>> cola = new ColaGenerica<>();
        cola.encolar(arbol);
        cola.encolar(null);
        ArbolGeneral<Character> arbol2;
        ArbolGeneral<Character> arbolDevolver = null;
        int nivel = 0;
        int cantNivel = 0;
        int maxHijos = Integer.MIN_VALUE;
        boolean seguir = true;
        while ((!cola.esVacia()) && seguir){
            arbol2 = cola.desencolar();
            if (arbol2 != null){
                cantNivel++;
                ListaGenerica<ArbolGeneral<Character>> hijos = arbol2.getHijos();
                if (hijos.tamanio() > maxHijos){
                    maxHijos = hijos.tamanio();
                    arbolDevolver = arbol2;
                }
                hijos.comenzar();
                while (!hijos.fin()){
                    cola.encolar(hijos.proximo());
                }
            }
            else if (!cola.esVacia()){
                if ((cantNivel - 1) != nivel){
                    seguir = false;
                }
                nivel++;
                cantNivel = 0;
                cola.encolar(null);
            }
        }

        if ((cantNivel - 1) != nivel){
            seguir = false;
        }

        if (seguir)
            return arbolDevolver;
        else
            return null;
    }
}
