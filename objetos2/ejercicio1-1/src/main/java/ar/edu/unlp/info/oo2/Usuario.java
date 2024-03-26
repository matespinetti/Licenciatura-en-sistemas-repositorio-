package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String screenName;
    private List<TweetInt> tweets;


    public Usuario (String screenName){
        tweets = new ArrayList<>();
        this.screenName = screenName;
    }

    public String getScreenName(){
        return screenName;
    }

    public void twittear(String texto){

        try {
            Tweet t = new Tweet(texto);
            tweets.add(t);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    public void retwittear(Tweet origen) {
        tweets.add(origen);
    }
    public void borrarTweets(){
        tweets.clear();
    }


}
