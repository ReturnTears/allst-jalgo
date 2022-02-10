package com.allst.jvalgo;

import org.junit.Test;

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
        System.out.println(System.currentTimeMillis());
    }
}
