package com.yhongm.dynamic_core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by yhongm on 2017/03/08.
 */

public interface ResultAdapter<R, T> {
    Type responseType();

    T adapter(Result<R> result);

    abstract class Factory {
        public abstract ResultAdapter<?, ?> get(Type returnType, Annotation[] annotations, Dynamic dynamic);

        protected static Class<?> getRawType(Type type) {
            return Utils.getRawType(type);
        }
    }
}
