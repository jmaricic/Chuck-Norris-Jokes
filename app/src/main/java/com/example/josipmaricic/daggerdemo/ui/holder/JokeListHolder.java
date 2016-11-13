package com.example.josipmaricic.daggerdemo.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.josipmaricic.daggerdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Josip on 13.11.2016..
 */

public class JokeListHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.joke_list_text_view)
    TextView mJokeTextView;

    public JokeListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setJoke(String mJoke) {
        mJokeTextView.setText(mJoke);
    }
}
