package com.just.see.justsee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.just.see.justsee.daxiang.ui.DaXiangFragment;
import com.just.see.justsee.qiushibaike.ui.QBListActivity;
import com.just.see.justsee.reactnative.JustSeeReactActivity;

public class JustSeeHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_just_see_home);
        FragmentManager fragmentManager = getSupportFragmentManager();
        DaXiangFragment daXiangFragment = new DaXiangFragment();
        fragmentManager.beginTransaction().add(R.id.container, daXiangFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.just_see_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.react_native:
                startActivity(new Intent(this, JustSeeReactActivity.class));
                return true;
            case R.id.QB:
                startActivity(new Intent(this, QBListActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
