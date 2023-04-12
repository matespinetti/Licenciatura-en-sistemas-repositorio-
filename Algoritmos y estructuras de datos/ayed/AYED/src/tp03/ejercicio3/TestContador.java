package tp03.ejercicio3;

import tp03.ejercicio1.ArbolBinario;
import tp02.ejercicio2.*;

public class TestContador {

	public static void main(String[] args) {
		ArbolBinario <Integer> a = null;
		a= new ArbolBinario (4);
		a.agregarHijoIzquierdo(new ArbolBinario(5));
		a.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(6) );
		
		ContadorArbol c = new ContadorArbol(a);
		ListaEnlazadaGenerica<Integer> lista = c.numerosPares();
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}

	}

}
