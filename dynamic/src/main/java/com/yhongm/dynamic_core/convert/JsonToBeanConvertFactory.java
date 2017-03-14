package com.yhongm.dynamic_core.convert;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.yhongm.dynamic_core.Converter;
import com.yhongm.dynamic_core.Dynamic;
import com.yhongm.dynamic_core.ExecuteResponse;
import com.yhongm.dynamic_core.Utils;

import org.json.JSONObject;

import java.io.IOException;
import java.io.StringReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by yhongm on 2017/03/10.
 * json转换器
 */

public class JsonToBeanConvertFactory extends Converter.Factory {

    private Gson gson;

    private JsonToBeanConvertFactory(Gson gson) {
        this.gson = gson;
    }

    public static JsonToBeanConvertFactory create() {
        return create(new Gson());
    }

    private static JsonToBeanConvertFactory create(Gson gson) {
        return new JsonToBeanConvertFactory(gson);
    }

    @Override
    public JsonToBeanConverter<ExecuteResponse<JSONObject>> resultConverter(Type type, Annotation[] annotations, Dynamic dynamic) {
        Log.i("JsonToBean", "15:13/resultConverter:jsonObject,type:" + Utils.getRawType(type));// yhongm 2017/03/13 15:13

        TypeAdapter<ExecuteResponse<JSONObject>> adapter = (TypeAdapter<ExecuteResponse<JSONObject>>) gson.getAdapter(TypeToken.get(type));
        return new JsonToBeanConverter<ExecuteResponse<JSONObject>>(gson, adapter);

    }

    public static class JsonToBeanConverter<T> implements Converter<ExecuteResponse<JSONObject>, T> {

        private final Gson gson;
        private final TypeAdapter<T> adapter;

        public JsonToBeanConverter(Gson gson, TypeAdapter<T> adapter) {
            this.gson = gson;
            this.adapter = adapter;
        }


        @Override
        public T conver(ExecuteResponse<JSONObject> value) throws IOException {
            JSONObject body = value.getBody();
            StringReader reader = new StringReader(body.toString());
            JsonReader jsonReader = new JsonReader(reader);
            T read = adapter.read(jsonReader);
            return read;
        }
    }
}
