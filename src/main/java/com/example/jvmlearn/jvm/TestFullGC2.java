package com.example.jvmlearn.jvm;

/**
 *
 * 1、动态年龄判断规则
 * 设置新生代大小为10m,eden:8m s1\s0:1m
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -
 * XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -
 * XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 *
 *
 * @author jt
 * @date 2020-5-16
 */
public class TestFullGC2 {

    public static void main(String[] args) {


        byte[] array0 = new byte[1 * 1024 * 1024];
        byte[] array1 = new byte[3 * 1024 * 1024-88];
//        array1 = new byte[2 * 1024 * 1024];
//        array1 = new byte[2 * 1024 * 1024];

//        array1 = null;


//        byte[] array2 = new byte[2*1024 * 1024];
//
//        array2 =null;


        //以上占用6m+,存活2m,无法放入s区，下面触发young gc
//        byte[] array3 = new byte[1*1024 * 1024];//128kb


    }



}

/**
 *
 * 为什么模拟不出文档中的示例是因为环境初始状态不同，当前这个类main方法什么都没有，执行后查看gc.log可以看到，初始已经占用了67% eden
 * 本类环境初始状态 eden space 8192K,  67%
 * Java HotSpot(TM) 64-Bit Server VM (25.171-b11) for windows-amd64 JRE (1.8.0_171-b11), built on Mar 28 2018 16:06:12 by "java_re" with MS VC++ 10.0 (VS2010)
 * Memory: 4k page, physical 16658152k(6322924k free), swap 37581460k(15638280k free)
 * CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:MaxTenuringThreshold=15 -XX:NewSize=10485760 -XX:OldPLABSize=16 -XX:PretenureSizeThreshold=10485760 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:SurvivorRatio=8 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:-UseLargePagesIndividualAllocation -XX:+UseParNewGC
 * Heap
 *  par new generation   total 9216K, used 5496K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 *   eden space 8192K,  67% used [0x00000000fec00000, 0x00000000ff15e0f0, 0x00000000ff400000)
 *   from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 *   to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 *  concurrent mark-sweep generation total 10240K, used 0K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 *  Metaspace       used 4002K, capacity 4628K, committed 4864K, reserved 1056768K
 *   class space    used 440K, capacity 464K, committed 512K, reserved 1048576K
 */
