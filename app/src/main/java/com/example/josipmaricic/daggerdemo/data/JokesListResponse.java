package com.example.josipmaricic.daggerdemo.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Josip on 13.11.2016..
 */

public class JokesListResponse implements Serializable {

    private String type;
    private List<JokeData> value;

    public JokesListResponse(String type, List<JokeData> value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<JokeData> getJokeData() {
        return value;
    }

    public void setJokeData(List<JokeData> jokeData) {
        this.value = jokeData;
    }
}
