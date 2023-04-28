package tp04.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class Pruebaej4 {
    public static void main(String[] args) {

        ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(5, new ListaEnlazadaGenerica<ArbolGeneral<Integer>>());
        a.agregarHijo(new ArbolGeneral<>(15, new ListaEnlazadaGenerica<ArbolGeneral<Integer>>()));
        a.agregarHijo(new ArbolGeneral<Integer>(23));
        a.agregarHijo(new ArbolGeneral<Integer>(51));
        a.agregarHijo(new ArbolGeneral<>(123));

        ListaGenerica<ArbolGeneral<Integer>> listaRaiz = a.getHijos();
        ListaGenerica<ArbolGeneral<Integer>> fullIzq = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
        fullIzq.agregarFinal(new ArbolGeneral<Integer>(53));
        listaRaiz.proximo().agregarHijo(new ArbolGeneral<>(99, fullIzq));


        System.out.println(a.altura());
        System.out.println(a.nivel(123));
        System.out.println(a.ancho());
    }

}
