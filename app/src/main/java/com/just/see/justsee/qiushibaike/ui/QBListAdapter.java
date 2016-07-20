package com.just.see.justsee.qiushibaike.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.just.see.justsee.R;
import com.just.see.justsee.json.QBBean.QBContent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 何祥源 on 16/7/20.
 * Desc:
 */
public class QBListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<QBContent.ItemsBean> lists;

    public void setLists(List<QBContent.ItemsBean> lists) {
        this.lists = lists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new QBListViewHolder(View.inflate(parent.getContext(), R.layout.item_qiu_bai_card, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    class QBListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_head_portrait)
        CircleImageView headPortrait;
        @BindView(R.id.tv_name)
        TextView name;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.tv_content)
        TextView content;
        @BindView(R.id.iv_image)
        ImageView image;
        @BindView(R.id.cb_plus)
        CheckBox plus;
        @BindView(R.id.cb_sub)
        CheckBox sub;
        @BindView(R.id.iv_share)
        ImageView share;
        @BindView(R.id.iv_comment)
        ImageView comment;
        @BindView(R.id.tv_comment_count)
        TextView commentCount;

        public QBListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}
