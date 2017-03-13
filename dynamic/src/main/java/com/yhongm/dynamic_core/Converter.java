package com.yhongm.dynamic_core;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by yhongm on 2017/03/09.
 * 转换器
 */

public interface Converter<R, T> {//R为需要转换的类型，T为转换后的类型

    T conver(R value) throws IOException;

    abstract class Factory {
        public Converter<?, String> inputConverter(Type type, Annotation[] annotations, Dynamic dynamic) {
            return null;
        }

        public Converter<JSONObject, ?> resultConverter(Type type, Annotation[] annotations, Dynamic dynamic) {

            return null;
        }

        public Converter<?, ?> responseBodyConverter(Type type, Annotation[] annotations, Dynamic dynamic) {
            return null;
        }

        public Converter<?, ?> requestBodyConverter(Type type, Annotation[] annotations, Dynamic dynamic) {
            return null;
        }
    }
}
