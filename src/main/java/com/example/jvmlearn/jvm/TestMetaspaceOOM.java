package com.example.jvmlearn.jvm;

import com.example.jvmlearn.jvm.oom.MetaspaceFacade;
import com.example.jvmlearn.jvm.oom.MetaspaceFacadeImpl;
import com.example.jvmlearn.jvm.oom.MetaspaceFacadeInvocationHandler;

import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 模拟metaspace oom场景
 *
 * 限制大小为10m
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * @author jt
 * @date 2020-5-17
 */
public class TestMetaspaceOOM {


    private static Map<String, MetaspaceFacade> classLeakingMap = new HashMap<String, MetaspaceFacade>();
    private final static int NB_ITERATIONS_DEFAULT = 50000;


    public static void main(String[] args) {
        System.out.println("Class metadata leak simulator");

        int nbIterations = NB_ITERATIONS_DEFAULT;

        try {

            for (int i = 0; i < nbIterations; i++) {

                String fictiousClassloaderJAR = "file:" + i + ".jar";

                URL[] fictiousClassloaderURL = new URL[] { new URL(fictiousClassloaderJAR) };

                URLClassLoader newClassLoader = new URLClassLoader(fictiousClassloaderURL);

                MetaspaceFacade t = (MetaspaceFacade) Proxy.newProxyInstance(newClassLoader,
                        new Class<?>[] { MetaspaceFacade.class },
                        new MetaspaceFacadeInvocationHandler(new MetaspaceFacadeImpl()));

                classLeakingMap.put(fictiousClassloaderJAR, t);
            }
        }
        catch (Throwable any) {
            System.out.println("ERROR: " + any);
        }

        System.out.println("Done!");
    }


}
