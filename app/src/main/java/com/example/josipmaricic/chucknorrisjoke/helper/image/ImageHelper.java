package com.example.josipmaricic.chucknorrisjoke.helper.image;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Josip on 14.11.2016..
 */

public class ImageHelper implements ImageHelperInterface {

    @Override
    public void loadImage(Context context, String from, ImageView into) {
        Glide.with(context).load(from).into(into);
    }

    @Override
    public void loadImage(Context context, @DrawableRes int placeholder, ImageView into) {
        Glide.with(context).load(placeholder).into(into);
    }

    @Override
    public void loadImage(Context context, String from, @DrawableRes int placeholder, @DrawableRes int errorImage, ImageView into) {
        Glide.with(context)
                .load(placeholder)
                .error(errorImage)
                .into(into);
    }

    @Override
    public void loadImageWithTransformation(Context context, String from, com.bumptech.glide.load.Transformation bitmapTransformation, ImageView into) {
        Glide.with(context)
                .load(from)
                .bitmapTransform(bitmapTransformation)
                .into(into);
    }

    @Override
    public void loadImageWithTransformation(Context context, String from, @DrawableRes int placeholder, @DrawableRes int errorImage, com.bumptech.glide.load.Transformation bitmapTransformation, ImageView into) {
        Glide.with(context).load(from)
                .placeholder(placeholder)
                .bitmapTransform(bitmapTransformation)
                .error(errorImage)
                .into(into);
    }
}
