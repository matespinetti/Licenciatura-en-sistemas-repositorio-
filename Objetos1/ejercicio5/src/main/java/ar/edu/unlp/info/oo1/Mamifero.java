package ar.edu.unlp.info.oo1;

import java.util.Date;

public class Mamifero {

    private String identificador;
    private String especie;

    private Date fechaNacimiento;

    private Mamifero padre;

    private Mamifero madre;

    public Mamifero(String identificador) {
        this.identificador = identificador;
    }
    public Mamifero(){

    }


    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getPadre() {
        return padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getMadre() {
        return madre;
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    public Mamifero getAbueloMaterno(){
        if (this.madre != null) {
            return this.madre.getPadre();
        }
        return null;
    }
    public Mamifero getAbuelaMaterna(){
        if (this.madre != null) {
            return this.madre.getMadre();
        }
        return null;
    }
    public Mamifero getAbueloPaterno(){
        if (this.padre != null) {
            return this.padre.getPadre();
        }
        return null;
    }
    public Mamifero getAbuelaPaterna(){
        if (this.padre != null){
            return this.padre.getMadre();
        }
        return null;

    }

    public Boolean tieneComoAncestroA(Mamifero m){
        boolean tiene = false;
        if (this.getPadre() != null ) {
            tiene = this.getPadre().getIdentificador().equals(m.getIdentificador()) ;
        }
        if (!tiene && this.getMadre() != null){
            tiene = this.getMadre().getIdentificador().equals(m.getIdentificador());
        }
        if (!tiene){
            if (this.getPadre() != null){
                tiene = this.getPadre().tieneComoAncestroA(m);
            }
            if (!tiene && this.getMadre() != null){
                tiene = this.getMadre().tieneComoAncestroA(m);
            }

        }


        return tiene;



    }
}
