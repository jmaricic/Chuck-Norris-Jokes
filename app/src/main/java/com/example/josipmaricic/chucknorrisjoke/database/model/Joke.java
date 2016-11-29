package com.example.josipmaricic.chucknorrisjoke.database.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Josip on 21.11.2016..
 */

public class Joke extends RealmObject {

    @PrimaryKey
    @SerializedName("joke")
    public String jokeText;

    public String getJokeText() {
        return jokeText;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

}
