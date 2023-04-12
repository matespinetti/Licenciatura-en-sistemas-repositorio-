package tp02.ejercicio3;

public class TestBalanceo {
	public static boolean estaBalanceado (String s) {
		boolean balanceado = true;
		
		
		PilaGenerica<Character> p = new PilaGenerica<Character>(); 
		int i = 0;
		
		while ((balanceado)&&(i < s.length())) {
			char letra = s.charAt(i);
			
			if ((letra == '{') | (letra == ('(')) | (letra == '[')) {
				p.apilar(letra);
				
			} 
			else if ((letra == '}') | (letra == ')') | (letra == ']')) {
				char letraA = p.desapilar();
				if ((letra == '}') &&  !(letraA == '{')) {
					balanceado = false;
					
				}
				else if ((letra == ']') && !(letraA == '[')) {
					balanceado = false;
					
				}
				else if ((letra == ')') && !(letraA == '(')) {
					balanceado = false;
				}
						
			}
			
			i++;
		
			
		}
		if (!p.esVacia())
			return false;
		else
			return balanceado;
	}
}
