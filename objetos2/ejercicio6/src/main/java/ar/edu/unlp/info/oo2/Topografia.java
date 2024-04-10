package ar.edu.unlp.info.oo2;

public abstract class Topografia{
    public abstract double getProporcionA();
    public abstract double getProporcionT();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Topografia)){
            return false;
        }
        Topografia t = (Topografia) o;
        return this.getProporcionA() == t.getProporcionA() && this.getProporcionT() == t.getProporcionT();

    }
}
