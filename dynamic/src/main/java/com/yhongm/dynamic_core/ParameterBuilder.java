package com.yhongm.dynamic_core;

/**
 * Created by yhongm on 2017/03/09.
 */

public class ParameterBuilder {
    private final String methodAnnotationValue;
    private final String methodAnnotation;
    StringBuilder sbMethodParameter = new StringBuilder();
    private String key;
    private String value;

    public ParameterBuilder(String methodAnnotation, String methodAnnotationValue) {
        this.methodAnnotation = methodAnnotation;
        this.methodAnnotationValue = methodAnnotationValue;
        if (methodAnnotation != null && methodAnnotationValue != null) {
            sbMethodParameter.append(methodAnnotation + "=" + methodAnnotationValue);
        }

    }

    public String build() {
        String parameter = sbMethodParameter.toString();
        sbMethodParameter.delete(0, sbMethodParameter.length());
        return parameter;
    }

    public void setKeyAndValue(String key, String value) {
        this.key = key;
        this.value = value;
        if (sbMethodParameter.length() == 0) {
            sbMethodParameter.append(this.key + "=" + this.value);
        } else {
            sbMethodParameter.append("," + this.key + "=" + this.value);
        }

    }
}
