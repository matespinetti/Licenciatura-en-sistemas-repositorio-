package ParcialCodigo;

public class ElementoArbol {
    private int valor;
    private char caracter;

    public ElementoArbol(int valor, char caracter) {
        this.valor = valor;
        this.caracter = caracter;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }
}
