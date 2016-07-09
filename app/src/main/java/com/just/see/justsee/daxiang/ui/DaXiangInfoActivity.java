package com.just.see.justsee.daxiang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.just.see.justsee.JsonBean.daxiang.DaXiangInfo;
import com.just.see.justsee.R;
import com.just.see.justsee.base.JustSeeActivity;
import com.just.see.justsee.daxiang.View.IDaXiangInfoView;
import com.just.see.justsee.daxiang.presenter.DaXiangInfoPresenter;
import com.just.see.justsee.util.Image;
import com.just.see.justsee.util.ToastUtil;
import com.just.see.justsee.view.JustSeeProgressDialog;
import com.zzhoujay.richtext.RichText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiyoung on 2016/7/9.
 */
public class DaXiangInfoActivity extends JustSeeActivity implements IDaXiangInfoView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.head_pic)
    ImageView headPic;
    @BindView(R.id.text)
    TextView richText;
    String id;
    DaXiangInfoPresenter presenter;
    JustSeeProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daxiang_info);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        if (intent == null) finish();
        initView(intent);
        presenter = new DaXiangInfoPresenter(this);
        progressDialog = new JustSeeProgressDialog(this);
        presenter.loadDaXiangInfo(id);
    }

    private void initView(Intent intent) {
        Bundle extras = intent.getExtras();
        id = extras.getString("id");
        String title = extras.getString("title");
        String headPic = extras.getString("headPic");
        collapsingToolbarLayout.setTitle(title);
        Image.loadImage(headPic, this.headPic);
    }

    public static Bundle setArguments(String infoId, String title, String headPic) {
        Bundle bundle = new Bundle();
        bundle.putString("id", infoId);
        bundle.putString("title", title);
        bundle.putString("headPic", headPic);
        return bundle;
    }

    @Override
    public void daXiangInfoLoaded(DaXiangInfo daXiangInfo) {
        if (daXiangInfo != null) {
            String content = daXiangInfo.body.article.content;
            RichText.from(content).into(richText);
        }
    }

    @Override
    public void showRefresh() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void hideRefresh() {
        if (progressDialog.isShowing())
            progressDialog.hide();
    }

    @Override
    public void showError(Throwable e) {
        ToastUtil.showToast(e.getMessage());
    }
}
