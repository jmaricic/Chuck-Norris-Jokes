package com.example.josipmaricic.daggerdemo.helper.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josipmaricic.daggerdemo.App;
import com.example.josipmaricic.daggerdemo.R;
import com.example.josipmaricic.daggerdemo.common.Constants;
import com.example.josipmaricic.daggerdemo.helper.image.ImageHelperInterface;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Josip on 14.11.2016..
 */

public class JokeDialog extends DialogFragment {

    @BindView(R.id.image_view)
    ImageView imageView;

    @BindView(R.id.joke_text)
    TextView jokeTextView;

    @Inject
    ImageHelperInterface imageHelper;

    private String jokeText;

    public static JokeDialog newInstance(String joke) {
        JokeDialog dialog = new JokeDialog();
        dialog.setJokeText(joke);
        return dialog;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_joke, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get().getComponent().inject(this);
        initUI(view);
    }

    private void initUI(View view) {
        ButterKnife.bind(this, view);
        jokeTextView.setText(jokeText);
        imageHelper.loadImage(getContext(), Constants.IMAGE_URL, imageView);
    }
}
