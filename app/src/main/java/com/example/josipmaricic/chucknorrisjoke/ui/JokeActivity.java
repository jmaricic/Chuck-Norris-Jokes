package com.example.josipmaricic.chucknorrisjoke.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.josipmaricic.chucknorrisjoke.App;
import com.example.josipmaricic.chucknorrisjoke.R;
import com.example.josipmaricic.chucknorrisjoke.base.BaseActivity;
import com.example.josipmaricic.chucknorrisjoke.presentation.JokePresenter;
import com.example.josipmaricic.chucknorrisjoke.view.JokeView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JokeActivity extends BaseActivity implements JokeView {

    @Inject
    JokePresenter mJokePresenter;

    @BindView(R.id.joke_text_view)
    TextView mJokeTextView;

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
        mJokePresenter.setView(this);
    }

    @OnClick(R.id.joke_button)
    void onJokeBtnClick() {
        mJokePresenter.getRandomJoke();
    }

    @Override
    public void showJoke(String joke) {
        if (!TextUtils.isEmpty(joke)) {
            mJokeTextView.setText(joke);
        }
    }

    @Override
    public void showError(String message) {
        if (!TextUtils.isEmpty(message)) {
            mJokeTextView.setText(message);
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
        mJokePresenter.getListOfJokes();
    }
}
