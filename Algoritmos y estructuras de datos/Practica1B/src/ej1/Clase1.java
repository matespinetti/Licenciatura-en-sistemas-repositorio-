package ej1;

public class Clase1 {
	public static void print1 (int n1, int n2) {
			for (int i = n1; i <= n2; i++) {
				System.out.println(i);
			}
		
	}
	
	public static void print2 (int n1, int n2) {
		while (n1 <= n2) {
			System.out.println (n1);
			n1++;
			
		}
	}
		
	public static void print3 (int n1, int n2) {
		if (n1 == n2) {
			System.out.println(n1);
			
			
		}else {
			System.out.println (n1);
			print3(n1+1, n2);
		}
			
	}
		
	
	
}
