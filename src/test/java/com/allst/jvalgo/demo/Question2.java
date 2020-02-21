package com.allst.jvalgo.demo;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Java8+
 * LocalDateTime
 * @author YiYa
 * @since 2020-02-16 下午 04:51
 */
public class Question2 {

    @Test
    public void test() {
        /*LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println(timestamp);*/

        Instant instant1 = Instant.now();
        long start = instant1.toEpochMilli();

        int[] testArr = new int[99999];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 9000000);
        }
        Instant instant2 = Instant.now();
        long end = instant2.toEpochMilli();

        System.out.println(end - start);
    }

}
