package com.samples.stream;

import com.google.common.collect.Lists;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: lanxinghua
 * Date: 2019/7/29 09:56
 * Desc:
 */
public class StreamTest1 {
    static List<String> stringCollection = Lists.newArrayList();
    static Map<String, String> map = new ConcurrentHashMap<>();
    static {
        for (int i = 0; i < 10; i++) {
            stringCollection.add("Index" +i);
        }
        for (int i = 0; i < 10 ; i++) {
            map.put("key" + i, i + "");
        }
    }

    public static void main(String[] args) {
        System.out.println(stringCollection.size());

        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
