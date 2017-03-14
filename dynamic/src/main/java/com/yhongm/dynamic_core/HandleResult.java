package com.yhongm.dynamic_core;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by yhongm on 2017/03/08.
 * 处理
 */

public class HandleResult<T> implements Result<T> {
    protected ClassMethod<T, ?> classMethod;
    protected Object[] args;

//    public HandleResult(ClassMethod classMethod, Object[] args) {
//        this.classMethod = classMethod;
//        this.args = args;
//    }

    @Override
    public Response<T> execute() {
        return null;
    }


    public void setArgs(ClassMethod classMethod, Object[] args) {
        this.classMethod = classMethod;
        this.args = args;
    }

    private Response<T> parseResponse(JSONObject s) throws IOException {
//        T response = classMethod.toResponse(s);
        T response = null;
        try {

            response = classMethod.toResponse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.success(response, s.toString());
    }

    private String HandleParameter() {
        return classMethod.handleParameterArgs(args);
    }
}
