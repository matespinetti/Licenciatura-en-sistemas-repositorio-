/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Mateo Spinetti
 */
public class Circulo extends Figura {
    private double radio;
    private double diametro = radio *2;

    public Circulo(double radio, String colorR, String colorL) {
        super(colorR, colorL);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
       return Math.PI * 2 * radio;
    }

    @Override
    public String toString() {
        return super.toString() + "Radio: " + radio + "Diametro: " + diametro; //To change body of generated methods, choose Tools | Templates.
    }
        
    
        
          
    
    
    
}
