package com.example.josipmaricic.daggerdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.josipmaricic.daggerdemo.App;
import com.example.josipmaricic.daggerdemo.R;
import com.example.josipmaricic.daggerdemo.base.BaseActivity;
import com.example.josipmaricic.daggerdemo.common.Constants;
import com.example.josipmaricic.daggerdemo.presentation.JokeListPresenter;
import com.example.josipmaricic.daggerdemo.ui.adapter.JokeListAdapter;
import com.example.josipmaricic.daggerdemo.view.JokeListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Josip on 13.11.2016..
 */

public class JokeListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, JokeListView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    JokeListPresenter jokeListPresenter;

    private JokeListAdapter mAdapter;
    private List<String> mData = new ArrayList<>();

    public static Intent getLaunchIntent(Context from, List<String> data) {
        Intent intent = new Intent(from, JokeListActivity.class);
        intent.putExtra(Constants.DATA, (Serializable) data);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_list);
        App.get().getComponent().inject(this);
        prepareData();
        initUi();
    }

    private void prepareData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(Constants.DATA)) {
                mData = (List<String>) extras.getSerializable(Constants.DATA);
            }
        }
    }

    @Override
    protected void initUi() {
        ButterKnife.bind(this);
        jokeListPresenter.setView(this);
        mSwipeRefreshLayout.setRefreshing(false);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter = new JokeListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setData(mData);
    }

    @Override
    public void onRefresh() {
        jokeListPresenter.getListOfJokes();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showJokes(List<String> mData) {
        mAdapter.setData(mData);
    }

    @Override
    public void showProgress() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
