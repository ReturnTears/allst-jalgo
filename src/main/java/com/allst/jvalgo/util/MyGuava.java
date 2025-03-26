package com.allst.jvalgo.util;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

/**
 * @author Hutu
 * @since 2025-03-26 下午 09:15
 */
public class MyGuava {
    public static void main(String[] args) {
        optionalMth();
        optionalJoiner();
    }
    public static void optionalMth() {
        Optional<Integer> possible = Optional.of(7);
        // possible.isPresent() : true
        System.out.println(possible.get());
    }

    public static void optionalJoiner() {
        Joiner joiner = Joiner.on(", ").skipNulls();
        List<String> list = Lists.newArrayList("Hi", null, "Halo", "hello");
        String join = joiner.join(list);
        System.out.println(join);
    }
}
