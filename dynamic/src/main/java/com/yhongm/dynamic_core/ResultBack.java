package com.yhongm.dynamic_core;

/**
 * Created by yhongm on 2017/03/08.
 */

public interface ResultBack<T> {
    void onResponse(Result<T> result, Response<T> response);

    void onFail(Result<T> result, Throwable throwable);
}
