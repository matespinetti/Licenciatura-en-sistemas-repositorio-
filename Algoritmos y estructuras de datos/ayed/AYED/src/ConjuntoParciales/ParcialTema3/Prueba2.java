package ConjuntoParciales.ParcialTema3;

import tp03.ejercicio1.ArbolBinario;

public class Prueba2 {

    public static void main(String[] args) {
        ArbolBinario<Integer> arbol43 = new ArbolBinario<>(43);
        arbol43.agregarHijoDerecho(new ArbolBinario<>(2));
        Parcial p = new Parcial(arbol43);
        System.out.println(p.isTwoTree(43));
    }
}
