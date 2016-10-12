package com.just.see.justsee.util;

import android.widget.ImageView;

import com.just.see.justsee.api.urls.QBUrl;
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
        }
    }

    public static void loadQBHeadIcon(String uid, String url, ImageView iv) {
        if (iv != null) {
            Picasso.with(iv.getContext())
                    .load(QBUrl.getQBHeadIconUrl(uid, url))
                    .into(iv);
        }
    }

    public static void loadQBImage(String id, String url, ImageView iv) {
        if (iv != null) {
            Picasso.with(iv.getContext())
                    .load(QBUrl.getQBUserImage(id, url))
                    .into(iv);
        }
    }

}
