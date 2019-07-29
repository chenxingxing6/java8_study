package com.samples.stream;

import com.google.common.collect.Lists;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * User: lanxinghua
 * Date: 2019/7/29 09:56
 * Desc:
 */
public class StreamTest1 {
    List<String> stringCollection = Lists.newArrayList();

    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            stringCollection.add("Index" +i);
        }
    }
}
