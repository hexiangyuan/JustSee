package com.just.see.justsee.ezbuy;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.just.see.justsee.base.JustSeeSwipeRefreshRecyclerActivity;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */

public class EzbuyActivity extends JustSeeSwipeRefreshRecyclerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected RecyclerView.LayoutManager setLayoutManager() {
        return new LinearLayoutManager(this);
    }
}
