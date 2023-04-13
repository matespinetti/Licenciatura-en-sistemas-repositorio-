package tp03.ejercicio1;

public class PruebaContarHojas {

	public static void main(String[] args) {
		ArbolBinario <Integer> a = new ArbolBinario <Integer>(new Integer(5));
		a.agregarHijoIzquierdo(new ArbolBinario<Integer> (new Integer(4)));
		a.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(new Integer(3)));
		a.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(5));
		a.agregarHijoDerecho(new ArbolBinario<Integer> (new Integer(7)));
		a.getHijoDerecho().agregarHijoDerecho(new ArbolBinario <Integer> (new Integer(9)));
		a.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(new Integer (6)));
		
		System.out.println(a.contarHojas());
		a = a.espejo();
		a.entreNiveles(1, 2);
	}

}
