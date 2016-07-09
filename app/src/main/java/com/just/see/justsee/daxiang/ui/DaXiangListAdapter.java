package com.just.see.justsee.daxiang.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.just.see.justsee.JsonBean.daxiang.DaXiangList;
import com.just.see.justsee.R;
import com.just.see.justsee.util.Image;
import com.just.see.justsee.util.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiyoung on 2016/7/9.
 */
public class DaXiangListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DaXiangList.Body.Article> articles;
    Context context;

    public DaXiangListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_daxiang_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (articles != null && articles.size() > 0)
            ((ViewHolder) holder).bind(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }

    public void setAdapterDate(List<DaXiangList.Body.Article> articles) {
        this.articles = articles;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.brief)
        TextView brief;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.read_num)
        TextView readNum;
        @BindView(R.id.pic)
        ImageView pic;

        DaXiangList.Body.Article article;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(DaXiangList.Body.Article article) {
            title.setText(article.title);
            brief.setText(article.brief);
            author.setText(article.author);
            date.setText(article.update_time);
            this.article = article;
            readNum.setText(String.format("阅读量：%s", article.read_num));
            Image.loadImage(article.raw_headpic, pic);
        }

        @Override
        public void onClick(View view) {
            ToastUtil.showToast(article.id);
            Intent i = new Intent(context, DaXiangInfoActivity.class);
            i.putExtras(DaXiangInfoActivity.setArguments(article.id,article.title,article.headpic));
            context.startActivity(i);
        }
    }
}
