package tp04.Ejercicio5;

public class AreaEmpresa {
    private String identificacion;
    private int transmicion;

    public AreaEmpresa(String identificacion, int transmicion) {
        this.identificacion = identificacion;
        this.transmicion = transmicion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getTransmicion() {
        return transmicion;
    }

    public void setTransmicion(int transmicion) {
        this.transmicion = transmicion;
    }
}
