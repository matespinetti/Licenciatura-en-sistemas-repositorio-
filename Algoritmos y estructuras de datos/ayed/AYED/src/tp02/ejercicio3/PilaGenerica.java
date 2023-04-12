package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class PilaGenerica<T> {
	ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
	
	public void apilar(T elem) {
		this.lista.agregarFinal(elem);
	}
	public T desapilar() {
		T dato = null;
		if (!this.lista.esVacia()){
			 dato = this.lista.elemento(this.lista.tamanio());
			this.lista.eliminarEn(this.lista.tamanio());
		}
		
		return dato;
		
		
	}
	
	public T tope() {
		if (!this.lista.esVacia()) {
			return this.lista.elemento(this.lista.tamanio());
		}
		else {
			return null;
		}
	}
	
	public boolean esVacia() {
		return this.lista.esVacia();
	}
}
