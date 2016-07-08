package com.just.see.justsee.daxiang;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.just.see.justsee.JsonBean.daxiang.DaXiangList;

import java.util.List;

/**
 * Created by xiyoung on 2016/7/9.
 *
 */
public class DaXiangListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DaXiangList.Body.Article> articles;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }

    public void setAdapterDate(List<DaXiangList.Body.Article> articles) {
        this.articles = articles;
    }
}
