package com.example.josipmaricic.chucknorrisjoke.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.josipmaricic.chucknorrisjoke.App;
import com.example.josipmaricic.chucknorrisjoke.R;
import com.example.josipmaricic.chucknorrisjoke.base.BaseActivity;
import com.example.josipmaricic.chucknorrisjoke.common.Constants;
import com.example.josipmaricic.chucknorrisjoke.helper.dialog.DialogHelper;
import com.example.josipmaricic.chucknorrisjoke.presentation.JokeListPresenter;
import com.example.josipmaricic.chucknorrisjoke.ui.adapter.JokeListAdapter;
import com.example.josipmaricic.chucknorrisjoke.ui.listener.OnListItemClickListener;
import com.example.josipmaricic.chucknorrisjoke.view.JokeListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Josip on 13.11.2016..
 */

public class JokeListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, JokeListView, OnListItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    JokeListPresenter mJokeListPresenter;

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
        mJokeListPresenter.setView(this);
        mSwipeRefreshLayout.setRefreshing(false);
        mAdapter = new JokeListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setData(mData);
        setListeners();
    }

    private void setListeners() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setListener(this);
    }

    @Override
    public void onRefresh() {
        mJokeListPresenter.getListOfJokes();
    }

    @Override
    public void showError(String message) {
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showJokes(List<String> mData) {
        if (mData != null) {
            mAdapter.setData(mData);
        }
    }

    @Override
    public void showProgress() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(String joke) {
        if (!TextUtils.isEmpty(joke)) {
            DialogHelper.showJokeDialog(getSupportFragmentManager(), joke);
        }
    }
}
