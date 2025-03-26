package com.allst.jvalgo.util;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Hutu
 * @since 2025-03-26 下午 09:16
 */
public class MyMapdb {
    public static void main(String[] args) {
        fileDb();

        //writeDb();
        //readDb();
        //putDb();
        //shiftDb();
        //listenerDb();
    }
    public static void fileDb() {
        DB dbDisk = DBMaker.fileDB("file3.db").checksumHeaderBypass().make();
        HTreeMap map = dbDisk.hashMap("onDisk").open();
        System.out.println(map.get("age"));
        System.out.println(map.entrySet());
    }

    /**
     * mapDB写数据到磁盘
     **/
    public static void writeDb() {
        DB db = DBMaker.fileDB("file1.db")  // 基于磁盘存储，进程结束后，数据不丢失。
                .checksumHeaderBypass() // 文件损坏（比如没有db.close（）有可能造成文件损坏）, 则修复。
                .allocateStartSize(1024 * 1024) // 初始化文件的大小，为1M
                .allocateIncrement(1024).make(); // 文件递增的大小为1KB
        // 在db中创建或打开name为map的map结构。name的名字是自己定义的。
        ConcurrentMap<String, String> map = db.hashMap("map2", Serializer.STRING, Serializer.STRING).createOrOpen();
        for (long i = 0L; i < 100000; i++) {
            map.put(Long.toString(i), "Halo Every One " + i);
        }
        db.close();  // 好习惯是进程结束的时候一定要db.close（）
    }

    /**
     * mapDB读数据从磁盘
     */
    public static void readDb() {
        DB db = DBMaker.fileDB("file1.db")
                .checksumHeaderBypass()
                .allocateStartSize(1024 * 1024)
                .allocateIncrement(1024).make();
        ConcurrentMap<String, String> map = db.hashMap("map2", Serializer.STRING, Serializer.STRING).createOrOpen();
        System.out.println(map.get("1314"));  // 从writeDb写入的数据，可以从这个进程中读取出来。因为是写到磁盘的。
        db.close();
    }

    /**
     * 存放
     */
    public static void putDb() {
        DB db = DBMaker.fileDB("file.db").make();
        ConcurrentMap<String, Long> map = db.hashMap("map", Serializer.STRING, Serializer.LONG).create();
        HTreeMap.KeySet<String> set = db.hashSet("set", Serializer.STRING).create();
        map.put("age", 23L);
        set.add("Halo");
        set.add("Word");
        set.add("Good");
        System.out.println(map.get("age"));
        System.out.println(set.getMap().entrySet());
    }

    /**
     * 事务
     */
    public static void shiftDb() {
        DB db = DBMaker.fileDB("file2.db")
                .fileMmapEnable()
                .transactionEnable() // 开启事务
                .closeOnJvmShutdown() // JVM关闭时关闭DB
                .make();
        ConcurrentMap<String, Long> map = db.hashMap("map", Serializer.STRING, Serializer.LONG).createOrOpen();
        map.put("hi", 520L);
        map.put("halo", 1314L);
        db.commit();
        System.out.println(map.get("hi"));
        map.put("foo", 1000L);
        System.out.println("before rollback foo: " + map.get("foo"));
        db.rollback();
        System.out.println("after rollback hi: " + map.get("hi"));
        System.out.println("after rollback foo: " + map.get("foo"));
    }

    /**
     * 监听
     */
    public static void listenerDb() {
        DB dbDisk = DBMaker.fileDB("file3.db").make(); // 初始化磁盘缓存
        DB dbMemory = DBMaker.memoryDB().make(); // 初始化堆内缓存
        HTreeMap onDisk = dbDisk.hashMap("onDisk").create(); // 过期数据存放在onDisk(磁盘缓存)中,磁盘缓存方便扩容，适合存放大量数据
        HTreeMap inMemory = dbMemory.hashMap("inMemory") // 少量数据存放在inMemory(堆内缓存)中,由于堆内缓存较小,但速度更快，适合存放热数据
                .expireAfterCreate(1, TimeUnit.SECONDS) // 设置过期时间
                .expireOverflow(onDisk) // 此寄存器溢出到磁盘
                .expireExecutor(Executors.newScheduledThreadPool(2)) // 启动自动过期
                .create();

        inMemory.put("hello", "world");
        inMemory.put("name", "WKang");
        inMemory.put("age", "30");
        inMemory.put("addr", "china henan");
        System.out.println(inMemory.get("hello"));
        try {
            //inMemory.clearWithExpire();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(inMemory.get("name"));
            dbMemory.close();
            dbDisk.close();
        }
    }
}
