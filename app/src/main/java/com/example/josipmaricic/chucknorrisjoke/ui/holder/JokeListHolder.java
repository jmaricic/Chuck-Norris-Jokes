package com.example.josipmaricic.chucknorrisjoke.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.josipmaricic.chucknorrisjoke.R;
import com.example.josipmaricic.chucknorrisjoke.ui.listener.OnFavoriteItemClickListener;
import com.example.josipmaricic.chucknorrisjoke.ui.listener.OnListItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by Josip on 13.11.2016..
 */

public class JokeListHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.joke_list_text_view)
    TextView mJokeTextView;

    private OnListItemClickListener mListener;
    private OnFavoriteItemClickListener mFavoriteListener;

    public JokeListHolder(View itemView, OnListItemClickListener listener, OnFavoriteItemClickListener favoriteListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mListener = listener;
        this.mFavoriteListener = favoriteListener;
    }

    public void setJoke(String mJoke) {
        if (!TextUtils.isEmpty(mJoke)) {
            mJokeTextView.setText(mJoke);
        }
    }

    @OnClick(R.id.joke_list_text_view)
    void onItemClick() {
        if (mListener != null) {
            mListener.onItemClick(mJokeTextView.getText().toString());
        }
    }

    @OnLongClick(R.id.joke_list_text_view)
    boolean onLongItemClick() {
        if (mFavoriteListener != null) {
            mFavoriteListener.onFavoriteItemClicked(mJokeTextView.getText().toString());
        }
        return true;
    }
}
