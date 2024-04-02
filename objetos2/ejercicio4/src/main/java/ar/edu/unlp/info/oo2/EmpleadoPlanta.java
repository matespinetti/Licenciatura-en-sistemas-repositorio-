package ar.edu.unlp.info.oo2;

public class EmpleadoPlanta extends Empleado {
    private boolean casado;
    private int hijos;
    private int antiguedad;

    public EmpleadoPlanta(boolean casado, int hijos, int antiguedad) {
        this.casado = casado;
        this.hijos = hijos;
        this.antiguedad = antiguedad;
    }

    public double sueldoBasico (){
        return 50000.0;
    }
    public double sueldoAdicional (){
        int cantidad =0;
        if (casado){
            cantidad +=5000;

        }
        cantidad += hijos*2000;
        cantidad += antiguedad*2000;
        return cantidad;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
