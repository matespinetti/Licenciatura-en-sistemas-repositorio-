package ConjuntoParciales.Ejercicio7.Ejercicio8;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;
import tp02.ejercicio2.ListaGenerica;

public class Ej8 {

    ArbolGeneral<Integer> arbol;

    public Ej8(ArbolGeneral<Integer> arbol) {
        this.arbol = arbol;
    }


    public ListaGenerica<Integer> resolverPorNiveles(){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
        ColaGenerica<ArbolGeneral<Integer>> cola= new ColaGenerica<ArbolGeneral<Integer>>();
        ArbolGeneral<Integer> arbol2 = arbol;
        cola.encolar(arbol);

        while (!cola.esVacia()){
            arbol2= cola.desencolar();
            ListaGenerica<ArbolGeneral<Integer>> hijos = arbol2.getHijos();
            int cantHijos = hijos.tamanio();
            int suma = 0;
            hijos.comenzar();
            while (!hijos.fin()){
                ArbolGeneral<Integer> hijo = hijos.proximo();
                if (cantHijos % 2 ==1){
                    suma += hijo.getDato();
                }
                cola.encolar(hijo);
            }


            if (cantHijos % 2 ==1)
                lista.agregarFinal(suma);



        }


    return lista;
    }






}
