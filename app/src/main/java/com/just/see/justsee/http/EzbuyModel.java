package com.just.see.justsee.http;

import com.just.see.justsee.api.service.EzbuyService;
import com.just.see.justsee.json.EzbuyProduct;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */

public class EzbuyModel {
    private static final EzbuyService ezbuyServicet = RetrofitHelper.setUrl("").create(EzbuyService.class);

    public Observable<ArrayList<EzbuyProduct>> getEzbuyProducts(int offset, int limit) {
        return ezbuyServicet.getEzbuyProducts(0, offset, limit, "");
    }
}
