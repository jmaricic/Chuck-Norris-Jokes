package com.example.josipmaricic.chucknorrisjoke.helper.dialog;

import android.support.v4.app.FragmentManager;

/**
 * Created by Josip on 14.11.2016..
 */

public class DialogHelper {

    public static void showJokeDialog(FragmentManager supportFragmentManager, String joke) {
        JokeDialog dialog = JokeDialog.newInstance(joke);
        dialog.show(supportFragmentManager, dialog.getTag());
    }
}
