package ar.edu.unlp.info.oo1;

public class PrismaRectangular extends Pieza {
    private int ladoMayor;
    private int ladoMenor;
    private int altura;

    @Override
    public double getVolumen() {
        return ladoMayor * ladoMenor * altura;
    }
}
