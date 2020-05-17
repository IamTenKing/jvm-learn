package com.example.jvmlearn.jvm;

import com.example.jvmlearn.jvm.oom.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 *-Xms10m -Xmx10m
 *
 *
 * 每次gc只回收一点点，就报这个错
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 *
 * -XX:-UseGCOverheadLimit
 * 指定这个选项, 会将原来的 java.lang.OutOfMemoryError: GC overhead limit exceeded 错误掩盖，变成更常见的 java.lang.OutOfMemoryError: Java heap space 错误消息
 *
 *
 * @author jt
 * @date 2020-5-17
 */
public class TestHeapOOM {

    static Map<String,Object>  map = new HashMap<>();

    public static void main(String[] args) {
        while(true){
            System.out.println(map.size());
            User user = new User();
            user.setAge(22);
            user.setName("test");
            user.setDes("dstest");
            map.put(UUID.randomUUID().toString(),user);


        }
    }
}
