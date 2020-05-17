package com.example.jvmlearn.jvm;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.invoke.MethodHandles;

/**
 * @author jt
 * @date 2020-5-9
 */
public class Test1 {

    //boolean默认值为false
    static boolean b;
    public static void main(String[] args) {

        //方法句柄
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        if(b){
            System.out.println("======1======");
        }

    }
}
