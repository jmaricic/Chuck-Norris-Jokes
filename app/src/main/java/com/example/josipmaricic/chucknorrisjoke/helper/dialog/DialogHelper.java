package com.example.josipmaricic.chucknorrisjoke.helper.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;

import com.example.josipmaricic.chucknorrisjoke.R;
import com.example.josipmaricic.chucknorrisjoke.ui.listener.DeleteJokeListener;

/**
 * Created by Josip on 14.11.2016..
 */

public class DialogHelper {

    public static void showJokeDialog(FragmentManager supportFragmentManager, String joke) {
        JokeDialog dialog = JokeDialog.newInstance(joke);
        dialog.show(supportFragmentManager, dialog.getTag());
    }

    public static void deleteJokeDialog(Context from, final DeleteJokeListener listener) {
        if (from == null) {
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(from);

        builder.setTitle(R.string.delete_title);
        builder.setMessage(R.string.delete_message);
        builder.setPositiveButton(R.string.delete_yese, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                listener.onDeleteJokeBtnClicked();
            }
        });

        builder.setNegativeButton(R.string.delete_no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
