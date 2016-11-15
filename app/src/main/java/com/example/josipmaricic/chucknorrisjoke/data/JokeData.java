package com.example.josipmaricic.chucknorrisjoke.data;

import java.io.Serializable;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public class JokeData implements Serializable {

    private int id;
    private String joke;

    public JokeData(int id, String joke) {
        this.id = id;
        this.joke = joke;
    }

    public int getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

}
