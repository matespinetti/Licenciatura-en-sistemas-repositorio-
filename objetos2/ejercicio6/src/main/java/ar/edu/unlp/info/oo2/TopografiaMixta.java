package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TopografiaMixta extends Topografia{
    private List<Topografia> topografias;


    public TopografiaMixta(){
        this.topografias = new ArrayList<Topografia>();
    }

    public void addTopografia(Topografia topografia){
        if (this.topografias.size() < 4){
            this.topografias.add(topografia);
        } else {
            throw new RuntimeException("No se pueden agregar mas de 4 topografias");
        }
    }

    public double getProporcionA() {
        double proporcionA = this.topografias.stream().mapToDouble(Topografia::getProporcionA).sum();
        return proporcionA / 4;
    }

    public double getProporcionT() {
        double proporcionT = this.topografias.stream().mapToDouble(Topografia::getProporcionT).sum();
        return proporcionT / 4;
    }


}
