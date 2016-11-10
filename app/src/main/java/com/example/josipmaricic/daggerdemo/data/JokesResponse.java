package com.example.josipmaricic.daggerdemo.data;

import java.io.Serializable;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public class JokesResponse implements Serializable {

    private String type;
    private Value value;

    public JokesResponse(String type, Value value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
