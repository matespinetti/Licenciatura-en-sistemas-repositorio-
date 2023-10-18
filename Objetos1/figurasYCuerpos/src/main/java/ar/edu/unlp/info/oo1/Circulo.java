package ar.edu.unlp.info.oo1;

public class Circulo {
    public double radio;
    public double diametro;

    public double getRadio() {
        return this.radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public double getDiametro(){
        return radio * 2;
    }

    public void setDiametro(int d){
        this.diametro = d;
        this.radio = (double) d /2;
    }

    public double getPerimetro() {
        return Math.PI * diametro;
    }

    public double getArea(){
        return Math.PI * radio * radio;
    }

}
