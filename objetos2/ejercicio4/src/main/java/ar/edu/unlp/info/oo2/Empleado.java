package ar.edu.unlp.info.oo2;

public abstract class Empleado {
    protected abstract double sueldoBasico ();
    protected abstract double sueldoAdicional ();
    protected double descuento(double sueldoBasico, double sueldoAdicional){
        return sueldoBasico* 0.13 +  sueldoAdicional * 0.05;
    }

    public double sueldo(){
        double sueldoBasico = this.sueldoBasico();
        double sueldoAdicional = this.sueldoAdicional();
        return sueldoBasico + sueldoAdicional - this.descuento(sueldoBasico, sueldoAdicional);
    }
}
