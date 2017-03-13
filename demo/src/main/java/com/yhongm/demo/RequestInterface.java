package com.yhongm.demo;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {
    String HOST = "http://api.tianapi.com/";

    /**
     * 微信精选列表
     */
    @GET("wxnew")
    Call<WeiXinItemBean> getWXHot(@Query("key") String key, @Query("num") int num, @Query("page") int page);
}