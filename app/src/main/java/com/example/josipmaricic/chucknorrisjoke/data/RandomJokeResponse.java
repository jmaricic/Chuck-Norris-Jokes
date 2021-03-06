package com.example.josipmaricic.chucknorrisjoke.data;

import java.io.Serializable;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public class RandomJokeResponse implements Serializable {

    private String type;
    private JokeData value;

    public RandomJokeResponse(String type, JokeData value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public JokeData getJokeData() {
        return value;
    }
}
