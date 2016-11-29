package com.example.josipmaricic.chucknorrisjoke.database;

import com.example.josipmaricic.chucknorrisjoke.database.model.Joke;

import io.realm.RealmResults;

/**
 * Created by Josip on 21.11.2016..
 */

public interface DatabaseInterface {

    void addJoke(String joke);
    RealmResults<Joke> getJoke();
    void removeJoke(String joke);
}
