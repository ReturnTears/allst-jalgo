package com.allst.jvalgo.util;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 用Java实现分段锁算法
 *
 * @author Hutu
 * @since 2025-03-25 下午 08:43
 */
public class MySegmentMap<K, V> implements Serializable {
    private final HashMap<K, V> hashMap;

    public MySegmentMap() {
        this.hashMap = new HashMap<>();
    }

    public V put(K key, V value) {
        synchronized (key) {
            try {
                Thread.sleep(5000);
                return hashMap.put(key, value);
            } catch (Throwable e) {
            }
        }
        return null;
    }

    public V get(K key) {
        synchronized (key) {
            try {
                return hashMap.get(key);
            } catch (Throwable e) {
            }
        }
        return null;
    }
}
