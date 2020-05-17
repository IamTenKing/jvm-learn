package com.example.jvmlearn.jvm;

/**
 *
 *
 * -XX:ThreadStackSize=1m
 * -XX:+PrintGCDetails
 * -Xloggc:gc.log
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=./
 * -XX:+UseParNewGC
 * -XX:+UseConcMarkSweepGC
 *
 *
 * Exception in thread "main" java.lang.StackOverflowError
 * @author jt
 * @date 2020-5-17
 */
public class TestStackOOM {

    static  int count = 0;

    public static void main(String[] args) {
        work();
    }

    private static void work() {

        System.out.println(++count);
        work();
    }
}
