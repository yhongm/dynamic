package com.yhongm.dynamic_core;

/**
 * Created by yhongm on 2017/03/08.
 */

public interface Result<T> {
    Response<T> execute();
}
