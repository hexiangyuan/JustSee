package com.just.see.justsee.daxiang.ui;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.just.see.justsee.json.daxiang.DaXiangList;
import com.just.see.justsee.json.weather.WeatherBean;
import com.just.see.justsee.R;
import com.just.see.justsee.util.DateFormat;
import com.just.see.justsee.util.Image;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiyoung on 2016/7/9.
 */
public class DaXiangListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DaXiangList.Body.Article> articles;
    final static int TYPE_WEATHER = 0;
    final static int TYPE_DAXIANG = 1;
    AppCompatActivity context;
    WeatherBean bean;

    public DaXiangListAdapter(AppCompatActivity context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_WEATHER:
                return new WeatherHolder(LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false));
            default:
                return new DaXiangHolder(LayoutInflater.from(context).inflate(R.layout.item_daxiang_list, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_DAXIANG:
                ((DaXiangHolder) holder).bind(articles.get(position - 1));
                break;
            case TYPE_WEATHER:
                if (bean != null) {
                    ((WeatherHolder) holder).bind("上海", bean);
                }
                break;
            default:
                break;
        }
    }

    public void setBean(WeatherBean bean) {
        this.bean = bean;
        notifyItemChanged(TYPE_WEATHER);
    }

    @Override
    public int getItemCount() {
        return articles == null ? 1 : articles.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_WEATHER;
            default:
                return TYPE_DAXIANG;
        }
    }

    public void setAdapterDate(List<DaXiangList.Body.Article> articles) {
        this.articles = articles;
    }

    class DaXiangHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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

        public DaXiangHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(DaXiangList.Body.Article article) {
            title.setText(article.title);
            brief.setText(article.brief);
            author.setText(article.author);
            date.setText(DateFormat.forMatDate(article.update_time));
            this.article = article;
            readNum.setText(String.format("阅读量：%s", article.read_num));
            Image.loadImage(article.raw_headpic, pic);
        }

        @Override
        public void onClick(View view) {
            DaXiangInfoActivity.launch(context, view.findViewById(R.id.pic), article.id, article.title, article.headpic);
        }
    }

    class WeatherHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.location)
        TextView tvLocation;
        @BindView(R.id.card)
        CardView cardView;
        @BindView(R.id.week)
        TextView tvWeek;
        @BindView(R.id.weather_type)
        ImageView ivWeatherType;
        @BindView(R.id.temp)
        TextView tvTemperature;
        @BindView(R.id.ic_wind)
        ImageView icWind;
        @BindView(R.id.tv_wind)
        TextView tvWind;
        @BindView(R.id.ic_wind_strength)
        ImageView icWindStrength;
        @BindView(R.id.tv_wind_strength)
        TextView tvWindStrength;
        @BindView(R.id.ic_humidity)
        ImageView icHumidity;
        @BindView(R.id.tv_humidity)
        TextView tvHumidity;

        public WeatherHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(String location, WeatherBean weatherBean) {
            if (weatherBean != null) {
                tvLocation.setText(location);
                tvLocation.setOnClickListener(this);
                tvWeek.setText(weatherBean.result.today.week);
                tvTemperature.setText(weatherBean.result.sk.temp);
                tvHumidity.setText(weatherBean.result.sk.humidity);
                tvWindStrength.setText(weatherBean.result.sk.wind_strength);
                tvWind.setText(weatherBean.result.sk.wind_direction);
            }
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.location:
                    ShowDialogLocation();
                    break;
            }
        }
    }

    private void ShowDialogLocation() {

    }
}
