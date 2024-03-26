package ar.edu.unlp.info.oo2;

public class Tweet implements TweetInt {



    private String texto;

    public Tweet(String texto) {
        if (texto.length() < 1 || texto.length() > 280) {
            throw new RuntimeException("El texto del tweet debe tener entre 1 y 280 caracteres");
        }
        this.texto = texto;
    }


}
