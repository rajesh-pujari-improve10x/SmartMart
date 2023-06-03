package com.improve10x.smartmart;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class BindingUtils {

    @BindingAdapter("imageUrl")

    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso.get().load(imageUrl).into(imageView);
    }
}
