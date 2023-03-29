package Ejercicio3;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Estudiante [] arrayE = new Estudiante [2];
		Profesor [] arrayP = new Profesor [3];
		for (int i = 0; i < 2; i++ ) {
			Scanner s = new Scanner(System.in);
			String nombre = s.nextLine();
			String apellido = s.nextLine();
			String comision = s.nextLine();
			String email = s.nextLine();
			String direccion = s.nextLine();
			arrayE [i] = new Estudiante(nombre, apellido, comision, email, direccion);
			
		}
		
		
		for (int i = 0; i < arrayE.length; i++) {
			System.out.println (arrayE[i].tusDatos());
		}

	}

}
