package com.just.see.justsee.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.just.see.justsee.R;

/**
 * Created by xiyoung on 2016/7/9.
 *
 */
public class Image {

    public static void loadImage(String url, ImageView iv) {
        Glide.with(iv.getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(iv);
    }
}
