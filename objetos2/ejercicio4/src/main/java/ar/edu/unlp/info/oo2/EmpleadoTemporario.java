package ar.edu.unlp.info.oo2;

public class EmpleadoTemporario extends Empleado {
    private int cantHorasTrabajo;
    private boolean estaCasado;
    private int cantHijos;

    public EmpleadoTemporario(int cantHorasTrabajo, boolean estaCasado, int cantHijos) {
        this.cantHorasTrabajo = cantHorasTrabajo;
        this.estaCasado = estaCasado;
        this.cantHijos = cantHijos;
    }

    protected double sueldoBasico() {
        return 20000 + this.cantHorasTrabajo * 300;
    }

    protected double sueldoAdicional() {
        double adicional = 0;
        if (this.estaCasado) {
            adicional += 5000;
        }
        adicional += this.cantHijos * 2000;
        return adicional;
    }

    public int getCantHorasTrabajo() {
        return cantHorasTrabajo;
    }

    public void setCantHorasTrabajo(int cantHorasTrabajo) {
        this.cantHorasTrabajo = cantHorasTrabajo;
    }

    public boolean isEstaCasado() {
        return estaCasado;
    }

    public void setEstaCasado(boolean estaCasado) {
        this.estaCasado = estaCasado;
    }

    public int getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(int cantHijos) {
        this.cantHijos = cantHijos;
    }
}
