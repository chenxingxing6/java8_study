package com.samples.stream;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.Aspect;
import cn.hutool.aop.aspects.TimeIntervalAspect;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * User: lanxinghua
 * Date: 2019/7/29 10:12
 * Desc:
 */
public class ParallelTest {
    public static final int MAX = 1000000;

    public void sortSequential(){
        List<String> values = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            values.add(UUID.randomUUID().toString());
        }
        long count = values.stream().sorted().count();
        System.out.println("count:"+ count);
    }

    public void sortParallel(){
        List<String> values = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            values.add(UUID.randomUUID().toString());
        }
        long count = values.stream().parallel().sorted().count();
        System.out.println("count:"+ count);
    }

    public static void main(String[] args) {
        ParallelTest parallelTest = ProxyUtil.proxy(new ParallelTest(), TimeIntervalAspect.class);

        parallelTest.sortSequential();

        // 使用并行流，量多耗费时间会更少
        parallelTest.sortParallel();
    }
}
