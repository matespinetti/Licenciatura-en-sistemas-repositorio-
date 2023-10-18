package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Farola {
    public boolean on;
    public List<Farola> neighbors;

    public Farola (){
        this.on = false;
        this.neighbors = new ArrayList<>();
    }

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        if (!this.isOn()) {
            this.on = true;
            for (Farola n: this.getNeighbors()) {
                if (!n.isOn()){
                    n.turnOn();
                }
            }
        }
    }

    public void turnOff() {
        if (this.isOn()) {
            this.on = false;
            for (Farola n: this.getNeighbors()) {
                if (n.isOn()){
                    n.turnOff();
                }
            }
        }
    }



    public void pairWithNeighbor(Farola otraFarola){
        this.neighbors.add(otraFarola);
        otraFarola.addNeighbor(this);
    }
    public List<Farola> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Farola> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor (Farola f){
        this.neighbors.add(f);
    }
}
