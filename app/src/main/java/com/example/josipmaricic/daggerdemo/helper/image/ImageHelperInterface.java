package com.example.josipmaricic.daggerdemo.helper.image;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * Created by Josip on 14.11.2016..
 */

public interface ImageHelperInterface {

    void loadImage(Context context, String from, ImageView into);

    void loadImage(Context context, @DrawableRes int placeholder, ImageView into);

    void loadImage(Context context, String from, @DrawableRes int placeholder, @DrawableRes int errorImage, ImageView into);

    void loadImageWithTransformation(Context context, String from, com.bumptech.glide.load.Transformation bitmapTransformation, ImageView into);

    void loadImageWithTransformation(Context context, String from, @DrawableRes int placeholder, @DrawableRes int errorImage, com.bumptech.glide.load.Transformation bitmapTransformation, ImageView into);
}