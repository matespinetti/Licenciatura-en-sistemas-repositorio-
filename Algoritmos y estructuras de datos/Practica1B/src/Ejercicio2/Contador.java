package Ejercicio2;

public class Contador {
	public static int[] contar(int n) {
		int [] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = n * (i+1);
		}
		
		return a;
	}

}


