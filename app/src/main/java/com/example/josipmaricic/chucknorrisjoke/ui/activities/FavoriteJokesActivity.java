package com.example.josipmaricic.chucknorrisjoke.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.josipmaricic.chucknorrisjoke.R;
import com.example.josipmaricic.chucknorrisjoke.base.BaseActivity;
import com.example.josipmaricic.chucknorrisjoke.database.DatabaseImpl;
import com.example.josipmaricic.chucknorrisjoke.database.DatabaseInterface;
import com.example.josipmaricic.chucknorrisjoke.helper.dialog.DialogHelper;
import com.example.josipmaricic.chucknorrisjoke.ui.adapter.JokeListAdapter;
import com.example.josipmaricic.chucknorrisjoke.ui.listener.DeleteJokeListener;
import com.example.josipmaricic.chucknorrisjoke.ui.listener.OnFavoriteItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Josip on 21.11.2016..
 */

public class FavoriteJokesActivity extends BaseActivity implements OnFavoriteItemClickListener, DeleteJokeListener{

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private JokeListAdapter mAdapter;
    private List<String> mData = new ArrayList<>();
    private String mJoke;

    private DatabaseInterface mDatabase;

    public static Intent getLaunchIntent(Context from) {
        return new Intent(from, FavoriteJokesActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_jokes);
        prepareData();
        initUi();
    }

    private void prepareData() {
        mDatabase = new DatabaseImpl();
        addData();
    }

    private void addData() {
        mData.clear();
        for (int i = 0; i < mDatabase.getJoke().size(); i++) {
            mData.add(mDatabase.getJoke().get(i).getJokeText());
        }
    }

    @Override
    protected void initUi() {
        ButterKnife.bind(this);
        mAdapter = new JokeListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setData(mData);
        mAdapter.setTouchListener(this);
    }

    @Override
    public void onFavoriteItemClicked(String joke) {
        mJoke = joke;
        DialogHelper.deleteJokeDialog(this, this);
    }

    @Override
    public void onDeleteJokeBtnClicked() {
        mDatabase.removeJoke(mJoke);
        addData();
        mAdapter.setData(mData);
    }

}
