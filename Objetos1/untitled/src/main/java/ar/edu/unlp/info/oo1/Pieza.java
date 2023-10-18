package ar.edu.unlp.info.oo1;

public abstract class Pieza {
    protected String material;
    protected String color;

    public abstract double getVolumen();
    public abstract double getSuperficieExterna();

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
