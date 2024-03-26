package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
    private List<Usuario> usuarios;

    public Twitter() {
        usuarios = new ArrayList<>();
    }



    private Usuario buscarUsuario(String screenName) {
        return this.usuarios.stream().filter(u -> u.getScreenName().equals(screenName)).findFirst().orElse(null);
    }

    public void agregarUsuario(String screenName) {
        Usuario usuario = buscarUsuario(screenName);
        if (usuario == null) {
            this.usuarios.add(new Usuario(screenName));
        }
    }
    public void twittear (Usuario u, String texto){
        u.twittear(texto);
    }

    public void retwittear( Usuario u, Tweet t){
        u.retwittear(t);
    }

    public void eliminarUsuario (String screenName){
        Usuario u = buscarUsuario(screenName);
        u.borrarTweets();
        this.usuarios.remove(u);
    }
}

