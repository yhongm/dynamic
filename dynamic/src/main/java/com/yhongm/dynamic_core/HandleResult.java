package com.yhongm.dynamic_core;

import java.io.IOException;

/**
 * Created by yhongm on 2017/03/08.
 * 处理基类
 */

public class HandleResult<T> implements Result<T> {
    protected ClassMethod<T, ?> classMethod;
    protected Object[] args;

    @Override
    public Response<T> execute() {
        return null;
    }


    public void setArgs(ClassMethod classMethod, Object[] args) {
        this.classMethod = classMethod;
        this.args = args;
    }

    /**
     * 将结果转换之后返回
     *
     * @param er
     * @return
     * @throws IOException
     */
    protected Response<T> parseResponse(ExecuteResponse er) throws IOException {
        T response = null;
        try {

            response = classMethod.toResponse(er);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.success(response, er.getBody().toString());
    }

    /**
     * 获取方法上的注释和参数注解
     *
     * @return
     */
    protected String HandleParameter() {
        return classMethod.handleParameterArgs(args);
    }

}
