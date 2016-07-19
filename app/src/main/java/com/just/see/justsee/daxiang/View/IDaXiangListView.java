package com.just.see.justsee.daxiang.View;

import com.just.see.justsee.jsonBean.daxiang.DaXiangList;
import com.just.see.justsee.jsonBean.weather.WeatherBean;
import com.just.see.justsee.base.BaseView;

/**
 * Created by xiyoung on 2016/7/9.
 */
public interface IDaXiangListView extends BaseView{

    void loadMoreData(DaXiangList daXiangList);

    void reFreshData(DaXiangList daXiangList);

    void weatherLoaded(WeatherBean weatherBean);

    void daXiangLoadCompleted();
}
