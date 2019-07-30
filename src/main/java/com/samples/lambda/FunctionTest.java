package com.samples.lambda;

import java.util.function.Function;

/**
 * User: lanxinghua
 * Date: 2019/7/30 13:52
 * Desc:
 */
public class FunctionTest {
    static Function<String, Integer> toInteger = Integer::valueOf;

    public static void main(String[] args) {
        Integer i = toInteger.apply("1");
        System.out.println(i);
    }
}
