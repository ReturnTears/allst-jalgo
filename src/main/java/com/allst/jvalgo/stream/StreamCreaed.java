package com.allst.jvalgo.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Hutu
 * @since 2024-09-30 下午 11:28
 */
public class StreamCreaed {
    public static void main(String[] args) {
        System.out.println(Stream.generate(Math::random).limit(10).collect(Collectors.toUnmodifiableList()));
    }
}
