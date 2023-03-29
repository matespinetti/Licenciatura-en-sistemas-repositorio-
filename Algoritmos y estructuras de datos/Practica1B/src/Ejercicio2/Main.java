package Ejercicio2;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un numero");
		int num = s.nextInt();
		int [] array = Contador.contar(num);
		for (int i= 0; i< array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println("Termino");
	}

}
