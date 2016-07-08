package com.just.see.justsee.daxiang.View;

import com.just.see.justsee.JsonBean.daxiang.DaXiangList;
import com.just.see.justsee.base.BaseView;

/**
 * Created by xiyoung on 2016/7/9.
 */
public interface IDaXiangListView extends BaseView{

    void DaXiangListLoaded(DaXiangList daXiangList, int page);
}
