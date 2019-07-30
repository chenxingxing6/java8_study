package com.samples.lambda;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * User: lanxinghua
 * Date: 2019/7/30 12:01
 * Desc: predicate 断言，断定
 */
public class PredicatesTest {
    static Predicate<String> stringLength = (s) -> s.length() > 0;
    static Predicate<String> stringEmpty = String::isEmpty;
    static Predicate<List> listPredicate = (list -> {
        return list.size() > 0;
    });

    public static void main(String[] args) {
        System.out.println(stringLength.test("66"));
        System.out.println(stringLength.negate().test("66"));

        System.out.println(stringEmpty.test(""));

        List<String> list = Lists.newArrayList("1");
        System.out.println(listPredicate.test(list));


    }
}
