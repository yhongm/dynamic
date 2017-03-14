package com.yhongm.dynamic_core;

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

}
