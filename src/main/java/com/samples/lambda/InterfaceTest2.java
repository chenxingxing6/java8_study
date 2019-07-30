package com.samples.lambda;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import lombok.Builder;
import lombok.Data;

/**
 * User: lanxinghua
 * Date: 2019/7/30 11:07
 * Desc: 函数式编程
 */
public class InterfaceTest2 {
    public static interface Converter<F, T> {
        T cvt(F from);
    }

    public static void main(String[] args) {
        // 基本数据类型转换
        Converter<String, Integer> stringToInteger = (from -> {
           return Integer.valueOf(from);
        });
        System.out.println(stringToInteger.cvt("100"));

        // 对象转换
        Converter<People1, People2> result = (from -> {
            return People2.builder().name(from.getName()).age(from.getAge()).build();
        });
        People1 people1 = new People1("lxh", "22");
        System.out.println(result.cvt(people1));

    }
}

@Data
@Builder
class People1{
    private String name;
    private String age;
}

@Data
@Builder
class People2{
    private String name;
    private String age;
}
