package com.just.see.justsee.api.service;

import com.just.see.justsee.json.EzbuyProduct;

import java.util.ArrayList;

import retrofit2.http.Field;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 何祥源 on 16/10/12.
 * Desc:
 */

public interface EzbuyService {
    @POST("http://android.65daigou.com/android.api")
    Observable<ArrayList<EzbuyProduct>> getEzbuyProducts(@Field("id") int id, @Field("offset") int offset, @Field("limit") int limit, @Field("originCode") String originCode);
}
