package tp03.ejercicio4;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio1.*;

public class prueba {

	public static void main(String[] args) {
		RedBinariaLlena redB = new RedBinariaLlena();
		ArbolBinario <Retardo> arbol = new ArbolBinario<Retardo>(new Retardo(15, 20));
		arbol.agregarHijoIzquierdo(new ArbolBinario <Retardo> (new Retardo (30, 40)));
		arbol.agregarHijoDerecho(new ArbolBinario<Retardo>(new Retardo (100, 60)));
		arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Retardo>(null));
		arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Retardo>(null));
		arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Retardo>(null));
		arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Retardo>(null));
		
		System.out.println(redB.retardoReenvio2(arbol)); 
	}

}
