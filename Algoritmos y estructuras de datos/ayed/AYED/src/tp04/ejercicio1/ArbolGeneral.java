package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		if (this.esHoja()) {
			return 0;
		}
		else {
			int max = Integer.MIN_VALUE;
			int cant = 0;
			if (this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cant = 1 + hijos.proximo().altura();
					if (cant >= max) {
						max = cant;
					}
				}
			}

			return max;
		}


	}

	public Integer nivel(T dato) {
		int nivel = 0;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ArbolGeneral<T> arbol2 = null;
		cola.encolar(this);
		cola.encolar(null);
		while ((!cola.esVacia())) {
			arbol2 = cola.desencolar();
			if (arbol2 != null) {
				if (arbol2.getDato().equals(dato)) {
					return nivel;
				}
				if (arbol2.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = arbol2.getHijos();
					hijos.comenzar();
					while (!hijos.fin()){
						cola.encolar(hijos.proximo());
					}

				}
			}
			else if (!cola.esVacia()) {
				nivel++;
				cola.encolar(null);
			}
		}

		return -1;

	}

	public Integer ancho() {
		int max = 0;
		int nivel = 0;
		int cant = 0;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ArbolGeneral<T> arbol2 = null;
		cola.encolar(this);
		cola.encolar(null);
		while ((!cola.esVacia())) {
			arbol2 = cola.desencolar();
			if (arbol2 != null) {
				cant ++;
				if (arbol2.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = arbol2.getHijos();
					hijos.comenzar();
					while (!hijos.fin()){
						cola.encolar(hijos.proximo());
					}

				}
			}
			else if (!cola.esVacia()) {
				nivel++;
				cola.encolar(null);
				if (cant > max) {
					max = cant;
				}
				cant = 0;
			}
		}


		return max;

	}


	private boolean encontrarDescendiente (ArbolGeneral<T> arbol, T b) {
		boolean encontre = false;
		if (arbol.getDato().equals(b)) {
			encontre = true;
		}
		else {
			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin() && !encontre) {
				encontre = encontrarDescendiente(hijos.proximo(), b);
			}


		}

		return encontre;
	}
	public boolean esAncestro(T a, T b){
		boolean esAnce = false;
		if (this.getDato().equals(a)) {
			esAnce = encontrarDescendiente(this, b);
		}
		else {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while (!hijos.fin() && !esAnce) {
				esAnce = hijos.proximo().esAncestro(a,b);
			}
		}

		return esAnce;
	}



}