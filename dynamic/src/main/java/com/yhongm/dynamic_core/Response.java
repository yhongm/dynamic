package com.yhongm.dynamic_core;

/**
 * Created by yhongm on 2017/03/08.
 */

public class Response<T> {
    T response;
    String s;

    public Response(T response, String s) {
        this.response = response;
        this.s = s;
    }

    public T getResponse() {
        return response;
    }

    public String getS() {
        return s;
    }

    public static <T> Response<T> success(T response, String s) {
        return new Response<T>(response, s);
    }
}
