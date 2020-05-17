package com.example.jvmlearn.jvm.oom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jt
 * @date 2020-5-17
 */
public class MetaspaceFacadeInvocationHandler implements InvocationHandler {

    private Object classAImpl;

    public MetaspaceFacadeInvocationHandler(Object impl) {
        this.classAImpl = impl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(classAImpl, args);
    }
}