package ar.edu.unlp.info.oo1;

public class Esfera extends Pieza {
    private int radio;
    @Override
    public double getVolumen() {
        return (double) 4 /3 * Math.PI * Math.pow(this.radio, 3);
    }
}
