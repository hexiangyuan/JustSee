package com.just.see.justsee.ezbuy;

import com.just.see.justsee.base.IBasePresenter;
import com.just.see.justsee.base.IBaseView;
import com.just.see.justsee.json.EzbuyProduct;

import java.util.ArrayList;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */

public interface EzbuyContract {

    interface View extends IBaseView<Presenter> {

        void showLoadingProgressBar(boolean show);

        void showLoadMore(boolean show);

        void showRefresh(boolean show);

        void showLoadProductError();

        void showProduct(ArrayList<EzbuyProduct> products);

    }

    interface Presenter extends IBasePresenter {

        void loadProducts(int offset,int limit);

    }
}
