package com.just.see.justsee.ezbuy;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.just.see.justsee.base.JustSeeActivity;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */

public class EzbuyActivity extends JustSeeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setTag("fragment");
        setContentView(frameLayout);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(EzbuyFragment.newInstance(), "fragment").commit();

    }
}
