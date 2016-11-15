package com.example.josipmaricic.chucknorrisjoke.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.josipmaricic.chucknorrisjoke.R;
import com.example.josipmaricic.chucknorrisjoke.ui.listener.OnListItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Josip on 13.11.2016..
 */

public class JokeListHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.joke_list_text_view)
    TextView mJokeTextView;

    private OnListItemClickListener mListener;

    public JokeListHolder(View itemView, OnListItemClickListener listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mListener = listener;
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
}
