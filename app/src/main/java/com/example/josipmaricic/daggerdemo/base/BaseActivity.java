package com.example.josipmaricic.daggerdemo.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.josipmaricic.daggerdemo.R;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    protected abstract void initUi();

    protected void showProgressDialog() {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = new ProgressDialog(this);
                mProgressDialog.setMessage(getString(R.string.loading));
                mProgressDialog.setCancelable(false);
            }

            mProgressDialog.show();
        } catch (Exception e) {
            //ok nothing, probably activity is not initialized yet
        }
    }

    protected void dismissProgressDialog() {
        try {
            if (mProgressDialog == null) {
                return;
            }

            mProgressDialog.dismiss();
        } catch (Exception e) {
            //ok nothing, probably activity is not initialized yet
        }
    }
}
