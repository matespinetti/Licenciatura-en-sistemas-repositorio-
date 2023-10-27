package ar.edu.unlp.info.oo1;

import java.time.LocalDateTime;

public class LlamaInterurbana extends Llamada {
    private int distancia;

    public LlamaInterurbana(LocalDateTime comienzo, int duracion, Long telefonoLlama, Long telefonoReceptor, int distancia) {
        super(comienzo, duracion, telefonoLlama, telefonoReceptor);
        this.distancia = distancia;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public double calcularCosto() {
        double costoPorMinuto;
        if (distancia < 100){
            costoPorMinuto = 2;
        } else if (distancia < 500) {
            costoPorMinuto = 2.5;
            
        } else {
            costoPorMinuto = 3;
        }


        return 5 + costoPorMinuto * duracion;
    }
}

