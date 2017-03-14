package com.yhongm.dynamic_core;

/**
 * Created by yhongm on 2017/03/14.
 */

public class ExecuteResponse<T> {
    T body;

    public void setBody(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }
}
