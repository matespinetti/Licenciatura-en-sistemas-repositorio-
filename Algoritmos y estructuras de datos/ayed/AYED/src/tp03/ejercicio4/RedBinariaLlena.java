package tp03.ejercicio4;
import java.util.concurrent.RecursiveTask;


import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio1.*;

public class RedBinariaLlena {
	private int max = Integer.MIN_VALUE;


	public int retardoReenvio(ArbolBinario<Retardo> a) {
	
		retardoReenvio( a, 0);
		return max;
	
	}
	
	private void retardoReenvio( ArbolBinario<Retardo> a, int retardo) {
		if (a.esHoja()) {
			if (retardo > max) {
				max = retardo;
			}
		}
		
		else {
			retardoReenvio( a.getHijoIzquierdo(), retardo + a.getDato().getRetardoIzq());
			retardoReenvio( a.getHijoDerecho(), retardo + a.getDato().getRetardoDer());
		}
	}
	
	public int retardoReenvio2 (ArbolBinario <Retardo> a) {
		if (a.esHoja()) {
			return 0;
		}
		else {
			int ri =  a.getDato().getRetardoIzq() + retardoReenvio2(a.getHijoIzquierdo());
			int rd = a.getDato().getRetardoDer() + retardoReenvio2(a.getHijoDerecho());
			return (Math.max(ri, rd));
		}
	}
}
