package ar.edu.unlp.info.oo2;

public class EmpleadoPasante extends Empleado {
    private int cantExamenesRendidos;
    public EmpleadoPasante(int cantExamenesRendidos) {
        this.cantExamenesRendidos = cantExamenesRendidos;
    }
    protected double sueldoBasico() {
        return 20000;
    }

    protected double sueldoAdicional(){
        return cantExamenesRendidos * 2000;
    }

    public int getCantExamenesRendidos() {
        return cantExamenesRendidos;
    }

    public void setCantExamenesRendidos(int cantExamenesRendidos) {
        this.cantExamenesRendidos = cantExamenesRendidos;
    }
}
