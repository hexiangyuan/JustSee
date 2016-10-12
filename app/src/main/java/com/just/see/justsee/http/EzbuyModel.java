package com.just.see.justsee.http;

import com.just.see.justsee.api.service.EzbuyService;
import com.just.see.justsee.json.EzbuyProduct;

import java.util.ArrayList;
import java.util.HashMap;

import rx.Observable;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */

public class EzbuyModel {
    private static final EzbuyService ezbuyServicet = RetrofitHelper.setUrl("http://www.65emall.net")
            .create(EzbuyService.class);

    public Observable<ArrayList<EzbuyProduct>> getEzbuyProducts(int offset, int limit) {
        ArrayList params = new ArrayList();
        params.add(Integer.valueOf(0));
        params.add(Integer.valueOf(offset));
        params.add(Integer.valueOf(limit));
        params.add("");
        HashMap args = new HashMap();
        args.put("id", Integer.valueOf(1));
        args.put("method", "Category.GetProducts");
        args.put("params", params);
        return ezbuyServicet.getEzbuyProducts(args);
    }
}
