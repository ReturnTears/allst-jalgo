package com.allst.jvalgo.util;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Hutu
 * @since 2025-03-26 下午 09:10
 */
public class AppRedisson {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(7);
        //config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RLock lock = redissonClient.getLock("anyLock");
        lock.lock();
        try {
            // 处理业务
            Random random = new Random();
            AtomicLong count = new AtomicLong(0);
            for (int i = 0; i < 100000; i++) {
                int anInt = random.nextInt(100);
                long l = count.addAndGet(anInt);
                System.out.println(i + " , curr value : " + anInt + ", : value = " + l);
            }
            System.out.println("total value : " + count.get());
        } finally {
            lock.unlock();
            redissonClient.shutdown();
        }
    }
}
