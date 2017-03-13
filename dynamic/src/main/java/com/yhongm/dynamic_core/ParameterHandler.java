package com.yhongm.dynamic_core;

import android.util.Log;

import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by yhongm on 2017/03/08.
 */

abstract class ParameterHandler<T> {
    abstract void apply(ParameterBuilder pb, T value) throws IOException;

    final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() {
            @Override
            void apply(ParameterBuilder pb, Iterable<T> values) {
                if (values == null)
                    return;

                for (T value : values) {
                    try {
                        ParameterHandler.this.apply(pb, value);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

    }

    final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() {
            @Override
            void apply(ParameterBuilder pb, Object value) {
                if (value == null) {
                    return;
                }
                for (int i = 0, size = Array.getLength(value); i < size; i++) {
                    try {
                        ParameterHandler.this.apply(pb, (T) Array.get(value, i));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    static final class MethodParamether<T> extends ParameterHandler<T> {
        String value;
        Converter<T, String> converter;
        String name;

        public MethodParamether(String name, String value, Converter<T, String> convert) {
            this.value = value;
            this.converter = convert;
            this.name = name;
        }

        @Override
        void apply(ParameterBuilder pb, T value) {
            try {
                pb.setKeyAndValue(name, converter.conver(value));
                Log.i("MethodParamether", "10:22/apply:value:" + value);// yhongm 2017/03/13 10:22
            } catch (Exception e) {
                Log.i("MethodParamether", "apply e:" + e.toString());
            }

        }
    }

}
