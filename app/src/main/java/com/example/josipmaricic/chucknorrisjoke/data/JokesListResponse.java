package com.example.josipmaricic.chucknorrisjoke.data;

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

    public List<JokeData> getJokeData() {
        return value;
    }
}
