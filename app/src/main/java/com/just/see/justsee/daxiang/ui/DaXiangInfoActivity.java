package com.just.see.justsee.daxiang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
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
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
    @BindView(R.id.author)
    TextView author;
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
        ViewCompat.setTransitionName(headPic, "headPic");
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void daXiangInfoLoaded(DaXiangInfo daXiangInfo) {
        if (daXiangInfo != null) {
            String content = daXiangInfo.body.article.content;
            author.setText(daXiangInfo.body.article.author);
            setRichText(content);
        }
    }

    private void setRichText(final String content) {
        Observable.create(new Observable.OnSubscribe<RichText>() {
            @Override
            public void call(Subscriber<? super RichText> subscriber) {
                RichText from = RichText.from(content);
                subscriber.onNext(from);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RichText>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RichText Text) {
                        Text.into(richText);
                    }
                });
    }

    @Override
    public void showRefresh() {
     /*   if (!progressDialog.isShowing())
            progressDialog.show();*/
    }

    @Override
    public void hideRefresh() {
    /*    if (progressDialog.isShowing())
            progressDialog.hide();*/
    }

    @Override
    public void showError(Throwable e) {
        ToastUtil.showToast(e.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        presenter.cancleSubscribe();
    }

    public static void launch(AppCompatActivity activity, View transitionView, String infoId, String title, String headPic) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionView, "headPic");
        Intent i = new Intent(activity, DaXiangInfoActivity.class);
        i.putExtra("id", infoId);
        i.putExtra("title", title);
        i.putExtra("headPic", headPic);
        ActivityCompat.startActivity(activity, i, optionsCompat.toBundle());
    }
}
