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
public class TestFullGC {

    public static void main(String[] args) {

        byte[] array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = null;//产生6m垃圾供回收

//        byte[] array2 = new byte[128 * 1024];//128kb


        //触发一次young gc, array2年龄+1，注意要模拟出动态年龄判断规则第一次young gc的from区必须大于50小于100%
        byte[] array3 = new byte[2 * 1024 * 1024];
        array3 = new byte[2 * 1024 * 1024];
        array3 = new byte[2 * 1024 * 1024];
        array3 = new byte[128*1024];
        array3= null;//产生6m垃圾供回收

        byte[] array4 = new byte[2 * 1024 * 1024];


    }



}

/**
 *
 * gc日志
 *
 * Java HotSpot(TM) 64-Bit Server VM (25.171-b11) for windows-amd64 JRE (1.8.0_171-b11), built on Mar 28 2018 16:06:12 by "java_re" with MS VC++ 10.0 (VS2010)
 * Memory: 4k page, physical 16658152k(6566120k free), swap 37581460k(12776584k free)
 * CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:MaxTenuringThreshold=15 -XX:NewSize=10485760 -XX:OldPLABSize=16 -XX:PretenureSizeThreshold=10485760 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:SurvivorRatio=8 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:-UseLargePagesIndividualAllocation -XX:+UseParNewGC
 * 3.173: [GC (Allocation Failure) 3.173: [ParNew: 7258K->1024K(9216K), 0.0034538 secs] 7258K->3175K(19456K), 0.0038163 secs] [Times: user=0.09 sys=0.03, real=0.00 secs]
 * 第二次gc日志显示 新生代全都占用为0
 * 3.179: [GC (Allocation Failure) 3.179: [ParNew: 7491K->0K(9216K), 0.0059223 secs] 9643K->5119K(19456K), 0.0060191 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 *
 * GC过后的堆内存使用情况
 * Heap
 *  par new generation   total 9216K, used 6367K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 *   eden space 8192K,  77% used [0x00000000fec00000, 0x00000000ff237d78, 0x00000000ff400000)
 *   from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 *   to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 *  concurrent mark-sweep generation total 10240K, used 5119K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 *  Metaspace       used 4002K, capacity 4628K, committed 4864K, reserved 1056768K
 *   class space    used 440K, capacity 464K, committed 512K, reserved 1048576K
 *
 *
 */
