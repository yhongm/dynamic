package com.yhongm.dynamic_core;

import com.yhongm.dynamic_core.annotation.MethodAnnotation;
import com.yhongm.dynamic_core.annotation.MethodParameter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by yhongm on 2017/03/08.
 */

public class ClassMethod<R, T> {
    private final String methodAnnotationValue;
    private final String methodAnnotation;
    ParameterHandler<?>[] parameterHandlers;
    Converter<ExecuteResponse, R> responseConverter;
    ResultAdapter<R, T> resultAdapter;//R为类型，T为转换后的类型

    public ClassMethod(Builder builder) {
        this.parameterHandlers = builder.parameterHandlers;
        this.responseConverter = builder.responseConverter;
        this.resultAdapter = builder.resultAdapter;
        this.methodAnnotation = builder.methodAnnotation;
        this.methodAnnotationValue = builder.methodAnnotationValue;
    }

    public String handleParameterArgs(Object[] args) {
        ParameterBuilder parameterBuilder = new ParameterBuilder(methodAnnotation, methodAnnotationValue);
        int argumentLeng = args != null ? args.length : 0;
        ParameterHandler<Object>[] handlers = (ParameterHandler<Object>[]) parameterHandlers;
        if (argumentLeng != parameterHandlers.length) {
            //参数长度不一致，抛出异常
            throw new IllegalArgumentException("参数异常");

        }
        for (int i = 0; i < argumentLeng; i++) {
            try {
                handlers[i].apply(parameterBuilder, args[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return parameterBuilder.build();
    }


//    public R toResponse(String s) throws IOException {
//        return responseConverter.conver(s);
//    }

    public R toResponse(ExecuteResponse executeResponse) throws IOException {
        return responseConverter.conver(executeResponse);
    }

    public static class Builder<T, R> {
        Dynamic dynamic;
        Annotation[][] methodParameterAnnotations;
        Type[] methodParameterTypes;
        Method method;
        Annotation[] methodAnnotations;
        Type responseType;
        ResultAdapter<T, R> resultAdapter;
        Converter<T, R> responseConverter;
        private String methodAnnotation;
        private String methodAnnotationValue;
        ParameterHandler[] parameterHandlers;

        public Builder(Dynamic dynamic, Method method) {
            this.dynamic = dynamic;
            this.methodAnnotations = method.getAnnotations();
            this.methodParameterAnnotations = method.getParameterAnnotations();
            this.methodParameterTypes = method.getGenericParameterTypes();
            this.method = method;
        }

        public ClassMethod<?, ?> build() {
            resultAdapter = createCallAdapter();
            responseType = resultAdapter.responseType();
            responseConverter = createResponseConverter();

            for (Annotation annotation :
                    methodAnnotations) {
                parseMethodAnnotation(annotation);
            }
            int parameterCount = methodParameterAnnotations.length;
            parameterHandlers = new ParameterHandler[parameterCount];
            for (int i = 0; i < parameterCount; i++) {
                Type parameterType = methodParameterTypes[i];
                if (Utils.hasUnresolvableType(parameterType)) {
                    //抛出异常
                    throw new IllegalArgumentException("参数类型异常");
                }
                Annotation[] parameterAnnotation = methodParameterAnnotations[i];

                parameterHandlers[i] = parseMethodParameter(i, parameterType, parameterAnnotation);
            }
            return new ClassMethod<>(this);
        }

        private ParameterHandler parseMethodParameter(int index
                , Type parameterType, Annotation[] parameterAnnotations
        ) {
            for (Annotation annotation :
                    parameterAnnotations) {
                ParameterHandler parameterHandler = parseMethodParameterAnnotation(index, parameterType, annotation, parameterAnnotations);

                return parameterHandler;
            }
            return null;
        }

        private ParameterHandler parseMethodParameterAnnotation(int index, Type parameterType, Annotation annotation, Annotation[] parameterAnnotations) {
            if (annotation instanceof MethodParameter) {
                String value = ((MethodParameter) annotation).value();
                Class<?> rawType = Utils.getRawType(parameterType);
                Converter<Object, String> converter;
                if (Iterable.class.isAssignableFrom(rawType)) {
                    ParameterizedType parameterizedType = (ParameterizedType) parameterType;
                    Type iterableType = Utils.getParameterUpperBound(0, parameterizedType);
                    converter = dynamic.stringConverer(iterableType, parameterAnnotations);
                    return new ParameterHandler.MethodParamether(value, value, converter).iterable();
                } else if (rawType.isArray()) {
                    Class<?> arrayComponentType = Utils.boxIfPrimitive(rawType);
                    converter = dynamic.stringConverer(arrayComponentType, parameterAnnotations);
                    return new ParameterHandler.MethodParamether<>(value, value, converter).array();
                } else {
                    converter = dynamic.stringConverer(parameterType, parameterAnnotations);
                    return new ParameterHandler.MethodParamether<>(value, value, converter);
                }


            }
            return null;
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof MethodAnnotation) {
                this.methodAnnotation = "methodAnnotation";
                String methodAnnotationValue = ((MethodAnnotation) annotation).value();
                parseMethodAndValue(annotation.annotationType().getSimpleName(), methodAnnotationValue);
            }
        }

        private void parseMethodAndValue(String methodAnnotation, String methodAnnotationValue) {
            this.methodAnnotationValue = methodAnnotationValue;
            this.methodAnnotation = methodAnnotation;
        }

        private Converter createResponseConverter() {
            Annotation[] annotations = method.getAnnotations();
            return dynamic.responseBodyConverter(responseType, annotations);
        }

        private ResultAdapter<T, R> createCallAdapter() {
            Type returnType = method.getGenericReturnType();
            if (Utils.hasUnresolvableType(returnType)) {
                //抛出异常
                throw new IllegalArgumentException("返回类型错误");
            }
            if (returnType == Void.class) {
                //抛出异常
                throw new IllegalArgumentException("返回类型为空");
            }
            Annotation[] annotations = method.getAnnotations();
            return (ResultAdapter<T, R>) dynamic.callAdapter(returnType, annotations);
        }
    }
}
