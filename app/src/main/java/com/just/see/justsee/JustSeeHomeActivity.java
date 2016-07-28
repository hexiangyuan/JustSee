package com.just.see.justsee;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.just.see.justsee.daxiang.ui.DaXiangFragment;

public class JustSeeHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_just_see_home);
        FragmentManager fragmentManager = getSupportFragmentManager();
        DaXiangFragment daXiangFragment = new DaXiangFragment();
        fragmentManager.beginTransaction().add(R.id.container,daXiangFragment).commit();
    }
}
