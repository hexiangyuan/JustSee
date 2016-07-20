package com.just.see.justsee.api.service;

import com.just.see.justsee.jsonBean.QBBean.QBContent;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 何祥源 on 16/7/19.
 * Desc:
 */
public interface QBService {
    @GET("")
    Observable<QBContent> getCategory();

    @GET("article/list/{category}")
    Observable<QBContent> getContentByCategory(@Path("category") String category, @Query("page") int page, @Query("count") int count);
}
