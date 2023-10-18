package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

    private List<Pieza> piezas;

    public ReporteDeConstruccion() {
        this.piezas = new ArrayList<>();
    }

    public double getVolumenDeMaterial(String material){
        return this.piezas.stream().filter(pieza -> pieza.getMaterial().equals(material)).mapToDouble(Pieza::getVolumen).sum();
    }

    public double getSuperficieDeColor(String color){

    }


}
