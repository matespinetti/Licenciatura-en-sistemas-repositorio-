package tp03.ejercicio1;
import tp02.ejercicio3.*;
public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * 
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public int contarHojas() {
		if (this.esHoja()) {
			return 1;
		} else {
			int cantHojas = 0;
			if (this.tieneHijoIzquierdo()) {
				cantHojas += this.getHijoIzquierdo().contarHojas();

			}

			if (this.tieneHijoDerecho()) {
				cantHojas += this.getHijoDerecho().contarHojas();
			}

			return cantHojas;
		}

	}

	public ArbolBinario<T> espejo() {

		ArbolBinario<T> a = new ArbolBinario<T>(this.getDato());
		if (!this.esHoja()) {

			if (this.tieneHijoDerecho()) {
				a.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
			}

			if (this.tieneHijoIzquierdo()) {
				a.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
			}

		}
		
		return a;
	}

	public void entreNiveles(int n, int m) {
		int nivel = 1;
		ArbolBinario <T> arbol = null;
		ColaGenerica <ArbolBinario> cola = new ColaGenerica<ArbolBinario> ();
		cola.encolar(this);
		cola.encolar(null);
		while ((nivel <= m) &&(!cola.esVacia())) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (nivel >= n) {
					System.out.println(arbol.getDato());
				}
				
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
				
			} 
			else if (!cola.esVacia()){
				System.out.println("");
				cola.encolar(null);
				nivel++;
			}
		}
		
		
	}
	
	
	public void imprimirInorden () {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().imprimirInorden();
		}
		
	}
	public void imprimirArbol () {
		System.out.println(this.getDato());
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().imprimirArbol();
		}
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().imprimirArbol();
		}
	}
	

}
