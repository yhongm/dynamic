package com.yhongm.demo;

import com.yhongm.dynamic_core.Result;
import com.yhongm.dynamic_core.annotation.MethodAnnotation;
import com.yhongm.dynamic_core.annotation.MethodParameter;

/**
 * Created by yhongm on 2017/03/09.
 */

public interface HelloRequest {
    @MethodAnnotation("yhongm")
    Result<TestBean> test(@MethodParameter("hello") String[] str, @MethodParameter("mi") int mi);
}
