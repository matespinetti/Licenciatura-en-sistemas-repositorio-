package ConjuntoParciales.ParcialMonodistante;

import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {

        ArbolBinario<Integer> arbol = new ArbolBinario<>(35);
        arbol.agregarHijoIzquierdo(new ArbolBinario<>(5));
        arbol.agregarHijoDerecho(new ArbolBinario<>(20));
        arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(15));

        MonodistanteDeMandatoK m = new MonodistanteDeMandatoK();
        m.setArbol(arbol);
        System.out.println(m.esMondodistante(55));
    }
}
