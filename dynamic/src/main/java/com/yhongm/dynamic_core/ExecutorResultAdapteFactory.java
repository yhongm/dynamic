package com.yhongm.dynamic_core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/**
 * Created by yhongm on 2017/03/08.
 */

public class ExecutorResultAdapteFactory extends ResultAdapter.Factory {
    Executor callBackExecutor;

    public ExecutorResultAdapteFactory(Executor callBackExecutor) {
        this.callBackExecutor = callBackExecutor;
    }

    @Override
    public ResultAdapter<?, ?> get(Type returnType, Annotation[] annotations, Dynamic dynamic) {
        if (Utils.getRawType(returnType) != Result.class) {
            return null;
        }
        final Type callResponseType = Utils.getCallResponseType(returnType);
        return new ResultAdapter<Object, Object>() {
            @Override
            public Type responseType() {
                return callResponseType;

            }

            @Override
            public Object adapter(Result<Object> result) {
                return new ExecutorResultBack(callBackExecutor, result);
            }
        };

    }

    private class ExecutorResultBack<T> implements Result {
        Executor callBackExecutor;
        Result<T> delegate;

        public ExecutorResultBack(Executor callBackExecutor, Result<T> result) {
            this.callBackExecutor = callBackExecutor;
            this.delegate = result;
        }

        @Override
        public Response execute() {
            return delegate.execute();
        }
    }
}
