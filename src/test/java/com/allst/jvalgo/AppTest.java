package com.allst.jvalgo;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        String line = "<cas:user>admin</cas:user>";
        String regex = "<cas:user>(.*)</cas:user>";
        Matcher matcher = Pattern.compile(regex).matcher(line);
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(0));
            //提取出的值
            System.out.println(matcher.group(1));
        }
    }

    @Test
    public void test() {
        System.out.println(Integer.valueOf("05"));
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test2() {
        BigDecimal a = BigDecimal.ZERO;
        BigDecimal param = new BigDecimal("");
        boolean equals = a.equals(param);
        System.out.println(equals);

        BigDecimal params = new BigDecimal("");
        System.out.println(params.equals(null));
    }

    @Test
    public void test3() {
        Set<String> params = Sets.newHashSet();
        params.add("");
        params.add("");
        params.add("");

        System.out.println(params.isEmpty());
        System.out.println(params.contains(""));
        System.out.println(params.size());
    }
}
