package com.just.see.justsee.qiushibaike.view;

import com.just.see.justsee.json.QBBean.QBContent;

/**
 * Created by 何祥源 on 16/7/19.
 * Desc:
 */
public interface IQBListView {

    void showRefresh();

    void hideRefresh();

    void showError(String msg);

    void showCompleted();

    void listLoaded(QBContent qbContent);
}
