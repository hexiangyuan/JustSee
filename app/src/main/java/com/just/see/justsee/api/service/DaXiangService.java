package com.just.see.justsee.api.service;

import com.just.see.justsee.jsonBean.daxiang.DaXiangInfo;
import com.just.see.justsee.jsonBean.daxiang.DaXiangList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xiyoung on 2016/7/9.
 * 大象的api请求
 */
public interface DaXiangService {
    /**
     * get daxiang list json date
     * @param pageSize pageSize
     * @param page  page
     * @return
     */
    @GET("api/v1_0/art/list")
    Observable<DaXiangList> getDaXiangList(
            @Query("pageSize") int pageSize,
            @Query("page") int page);

    /**
     * get daxiang content by id
     * @param id id
     * @return
     */
    @GET("api/v1_0/art/info")
    Observable<DaXiangInfo> getDaXiangInfo(@Query("id") String id);
}

