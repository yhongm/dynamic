package com.yhongm.test;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RequestInterface {
    String HOST = "http://api.tianapi.com/";

    /**
     * 微信精选列表
     */
    @GET("wxnew")
    Call<WeiXinItemBean> getWXHot(@Query("key") String key, @Query("num") int num, @Query("page") int page);
}