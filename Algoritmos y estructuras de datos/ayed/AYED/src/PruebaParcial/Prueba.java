package PruebaParcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {
        ListaEnlazadaGenerica<String> listaStrings = new ListaEnlazadaGenerica<String>();
        listaStrings.agregarFinal("1");
        listaStrings.agregarFinal("0");
        listaStrings.agregarFinal("10");
        listaStrings.agregarFinal("00");


        ArbolBinario<Character> arbolBinario = new ArbolBinario<Character>();
        arbolBinario.agregarHijoIzquierdo(new ArbolBinario<>('A'));
        arbolBinario.agregarHijoDerecho(new ArbolBinario<>('J'));
        arbolBinario.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>('M'));
        arbolBinario.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>('N'));


        ListaGenerica<Character> resultado = new ListaEnlazadaGenerica<Character>();
        CodigoZigZag codigo = new CodigoZigZag();
        resultado= codigo.descifrarCodigo(arbolBinario, listaStrings);
        resultado.comenzar();
        while (!resultado.fin()){
            System.out.println(resultado.proximo());
        }


    }






}
