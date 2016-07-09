package com.just.see.justsee.view;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by xiyoung on 2016/7/9.
 */
public class JustSeeProgressDialog extends ProgressDialog {
    public JustSeeProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public JustSeeProgressDialog(Context context) {
        super(context);
    }
}
