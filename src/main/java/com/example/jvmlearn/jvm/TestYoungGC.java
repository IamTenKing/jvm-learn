package com.example.jvmlearn.jvm;

/**
 * @author jt
 * @date 2020-5-16
 *
 * 手动模拟young gc
 * 测试yonggc时打印gc日志，并分析gc日志
 */
public class TestYoungGC {

    public static void main(String[] args) {
        byte[] array1 = new byte[1024 * 1024];
         array1 = new byte[1024 * 1024];
         array1 = new byte[1024 * 1024];
         array1 = null;

//        byte[] bytes = new byte[2 * 1024 * 1024];


    }
}
