package com.just.see.justsee.util;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by xiyoung on 2016/7/9.
 */
public class Image {

    public static void loadImage(String url, ImageView iv) {
        if (iv != null) {
            Picasso.with(iv.getContext())
                    .load(url)
                    .into(iv);
           /* Glide.with(iv.getContext())
                    .load(url)
//                .placeholder(R.mipmap.ic_launcher)
                    .into(iv);*/
        }
    }
}
