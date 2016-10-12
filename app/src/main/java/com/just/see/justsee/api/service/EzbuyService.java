package com.just.see.justsee.api.service;

import com.just.see.justsee.json.EzbuyProduct;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */

public interface EzbuyService {
    @FormUrlEncoded
    @POST("/SG_android.ashx")
    Observable<ArrayList<EzbuyProduct>> getEzbuyProducts(@FieldMap Map<String,Object> map);
}
