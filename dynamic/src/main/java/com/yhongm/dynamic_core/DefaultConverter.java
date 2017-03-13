package com.yhongm.dynamic_core;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by yhongm on 2017/03/09.
 */

public class DefaultConverter extends Converter.Factory {
    @Override
    public Converter<?, String> inputConverter(Type type, Annotation[] annotations, Dynamic dynamic) {
        if (Utils.getRawType(type) == String.class) {
            return ToStringConverters.mInstance;
        }

        return super.inputConverter(type, annotations, dynamic);
    }

    static final class ToStringConverters implements Converter<Object, String> {
        public static final ToStringConverters mInstance = new ToStringConverters();

        @Override
        public String conver(Object value) throws IOException {
            return value.toString();
        }
    }
}
