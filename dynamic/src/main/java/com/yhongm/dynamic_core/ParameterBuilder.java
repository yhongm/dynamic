package com.yhongm.dynamic_core;

import android.util.Log;

/**
 * Created by yhongm on 2017/03/09.
 */

public class ParameterBuilder {
    StringBuilder sbParameter = new StringBuilder();
    String methodParameter;
    private String key;
    private String value;


    public void apped(String conver) {
        sbParameter.append("," + conver);
    }

    public String build() {
        Log.i("ParameterBuilder", "18:44/build:str:" + sbParameter.toString());// yhongm 2017/03/09 18:44
        return sbParameter.toString();
    }

    public void setKeyAndValue(String key, String value) {
        Log.i("ParameterBuilder", "10:36/setKeyAndValue:key:" + key + ",value:" + value);// yhongm 2017/03/13 10:36
        this.key = key;
        this.value = value;
        sbParameter.append("key:" + this.key + ",value:" + this.value);
    }
}
