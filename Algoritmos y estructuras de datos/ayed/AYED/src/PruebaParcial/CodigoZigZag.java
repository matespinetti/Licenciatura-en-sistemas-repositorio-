package PruebaParcial;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class CodigoZigZag {
    public ListaGenerica<Character> descifrarCodigo (ArbolBinario<Character> arbol, ListaGenerica<String> listaDeSecuencias){
        ListaGenerica<Character> mensaje = new ListaEnlazadaGenerica<Character>();
        listaDeSecuencias.comenzar();
        while (!listaDeSecuencias.fin()){
            mensaje.agregarFinal(getCharacter(arbol, listaDeSecuencias.proximo())) ;

        }

        return mensaje;


    }

    private Character getCharacter(ArbolBinario<Character> arbol, String secuencia) {
        //ArbolBinario<Character> A = arbol;
        for (int i = 0; i<secuencia.length(); i++) {
            if (secuencia.charAt(i) == '0') {
               arbol= arbol.getHijoIzquierdo();
            } else
                arbol = arbol.getHijoDerecho();
        }
        return arbol.getDato();
    }
}
