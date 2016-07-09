package com.just.see.justsee;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.just.see.justsee.base.JustSeeActivity;
import com.just.see.justsee.daxiang.ui.DaXiangFragment;

public class HomeActivity extends JustSeeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        DaXiangFragment daXiangFragment = new DaXiangFragment();
        supportFragmentManager.beginTransaction().add(R.id.container, daXiangFragment).commit();
    }
}
