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
public class Triangulo extends Figura {
    private Double lado1, lado2, lado3;
    public Triangulo(double lado1, double lado2, double lado3, String colorR, String colorL) {
        super(colorR, colorL);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public Double getLado1() {
        return lado1;
    }

    public Double getLado2() {
        return lado2;
    }

    public Double getLado3() {
        return lado3;
    }

    public void setLado1(Double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(Double lado3) {
        this.lado3 = lado3;
    }
    
   public double calcularPerimetro () {
       return lado1 + lado2+ lado3;
   } 

    @Override
    public double calcularArea() {
        double s = calcularPerimetro () / 2;
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }

    @Override
    public String toString() {
        return super.toString() + " Lado1: " + this.lado1 + "Lado2: " + this.lado2 + "Lado3: " + this.lado3;
    }
    
    
           
    }
       
   
