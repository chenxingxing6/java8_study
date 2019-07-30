package com.samples.lambda;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User: lanxinghua
 * Date: 2019/7/30 11:18
 * Desc:
 */
public class LambdaTest1 {
    static List<String> names = Lists.newArrayList();
    static {
        names = Arrays.asList("bbb", "aaa", "ddd", "ccc");
    }

    public static void main(String[] args) {
        sort();
    }

    // 线程
    public static void threadTest(){
        new Thread(() -> {
            System.out.println(6666);
        }).start();
    }

    // 排序
    public static void sort(){
        print(names);

        // 默认升序
        Collections.sort(names);
        print(names);

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // "1".compareTo("2")  -1  // 升序
        // "2".compareTo("1")  1   // 降序
        print(names);

        // 降序
        Collections.sort(names, (a, b) -> b.compareTo(a));
        print(names);

        names.sort((a, b) -> a.compareTo(b));
        print(names);
    }

    public static void print(List<String> names){
        names.forEach(System.out::print );
        System.out.println();
    }
}
