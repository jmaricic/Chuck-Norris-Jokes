package com.example.josipmaricic.daggerdemo.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.josipmaricic.daggerdemo.App;
import com.example.josipmaricic.daggerdemo.R;
import com.example.josipmaricic.daggerdemo.base.BaseActivity;
import com.example.josipmaricic.daggerdemo.presentation.JokePresenter;
import com.example.josipmaricic.daggerdemo.view.JokeView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JokeActivity extends BaseActivity implements JokeView {

    @Inject
    JokePresenter jokePresenter;

    @BindView(R.id.joke_text_view)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.get().getComponent().inject(this);
        initUi();
    }

    @Override
    protected void initUi() {
        ButterKnife.bind(this);
        jokePresenter.setView(this);
    }

    @OnClick(R.id.joke_button)
    void onJokeBtnClick() {
        jokePresenter.getRandomJoke();
    }

    @Override
    public void showJoke(String joke) {
        if (!TextUtils.isEmpty(joke)) {
            mTextView.setText(joke);
        }
    }

    @Override
    public void showError(String message) {
        if (!TextUtils.isEmpty(message)) {
            mTextView.setText(message);
        }
    }

    @Override
    public void showJokes(List<String> mData) {
        if (mData != null) {
            startActivity(JokeListActivity.getLaunchIntent(this, mData));
        }
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        dismissProgressDialog();
    }

    @OnClick(R.id.joke_list_button)
    void onJokeListBtnClick() {
        jokePresenter.getListOfJokes();
    }
}
