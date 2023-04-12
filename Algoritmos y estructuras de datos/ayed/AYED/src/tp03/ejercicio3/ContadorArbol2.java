package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.PilaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol2 {
	private ArbolBinario<Integer> arbol;

	public ListaEnlazadaGenerica <Integer> numerosPares() {
		ListaEnlazadaGenerica <Integer> l = new ListaEnlazadaGenerica<>();
		numerosPares(l);
		return l;
	}
	private void numerosPares( ListaEnlazadaGenerica <Integer> l) {
		PilaGenerica <ArbolBinario<Integer>> pila = new PilaGenerica<ArbolBinario<Integer>>();
		if (this.arbol != null) {
			
			if (arbol.tieneHijoIzquierdo()) {
				pila.apilar(arbol);
				arbol = arbol.getHijoIzquierdo();
				numerosPares(l);
				arbol = pila.desapilar();
			}
			
			if (this.arbol.getDato() % 2 == 0) {
				l.agregarFinal(arbol.getDato());
			}
			
			if (arbol.tieneHijoDerecho()) {
				pila.apilar(arbol);
				arbol = arbol.getHijoDerecho();
				numerosPares(l);
				arbol = pila.desapilar();
			}
			
			
			
		}
	
		
		}
		
	
	public ContadorArbol2(ArbolBinario <Integer> arbol) {
		this.arbol = arbol;
	}
}
