package com.example.jvmlearn.jvm;

/**
 *
 * 单例的延迟初始化
 * @author jt
 * @date 2020-5-9
 */
public class Singleton {
    //私有构造方法
    private Singleton(){}


    //静态内部类只有被加载的时候才会被初始化
    private static class LazyHolder{
          static final  Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return LazyHolder.INSTANCE;
    }



}
