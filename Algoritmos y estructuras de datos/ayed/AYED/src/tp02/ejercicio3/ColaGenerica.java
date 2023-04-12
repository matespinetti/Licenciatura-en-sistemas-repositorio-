package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class ColaGenerica<T> {
	ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
	public void encolar(T elem) {
		this.lista.agregarFinal(elem);
	}
	public T desencolar() {
		T dato = this.lista.elemento(1);
		this.lista.eliminarEn(1);
		return dato;
	}
	
	public T tope() {
		return this.lista.elemento(1);
	}
	
	public boolean esVacia() {
		return this.lista.esVacia();
	}
}
