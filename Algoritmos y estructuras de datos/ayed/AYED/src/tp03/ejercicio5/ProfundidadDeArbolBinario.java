package tp03.ejercicio5;
import tp03.ejercicio1.*;
import tp02.ejercicio3.*;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> arbol;
	public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
		this.arbol= arbol;
	}
	public int sumaElementosProfundidad(int p) {
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		int suma = 0;
		int nivel = 0;
		ArbolBinario<Integer> arbol2 = null;
		cola.encolar(this.arbol);
		cola.encolar(null);
		while ((!cola.esVacia()) && (nivel <= p)) {
			arbol2 = cola.desencolar();
			if (arbol2 != null) {
				if (nivel == p) {
					suma += arbol2.getDato();
				}
				if (arbol2.tieneHijoIzquierdo()) {
					cola.encolar(arbol2.getHijoIzquierdo());
				}
				if (arbol2.tieneHijoDerecho()) {
					cola.encolar(arbol2.getHijoDerecho());
				}
			} 
			else if (!cola.esVacia()) {
				nivel++;
				cola.encolar(null);
			}
		}
		
		return suma;
	} 
}
