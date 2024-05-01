package ar.edu.unlp.info.oo2;

public class PermisosDecorator extends FileDecorator{
    public PermisosDecorator(FileComponent component) {
        super(component);
    }
    @Override
    public String prettyPrint() {
        return this.component.prettyPrint() + component.getPermisos() + "-" ;
    }
}
