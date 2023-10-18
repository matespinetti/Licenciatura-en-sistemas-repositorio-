package ar.edu.unlp.info.oo1;

public class Cilindro extends Pieza {
    private int radio;
    private int altura;

    @Override
    public double getVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }
}
