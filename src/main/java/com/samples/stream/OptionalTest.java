package com.samples.stream;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * User: lanxinghua
 * Date: 2019/7/29 14:01
 * Desc:
 */
public class OptionalTest {
    public static void main(String[] args) {
        List<People> peoples = Arrays.asList(People.builder().name("lxh").age("22").build());

        // test1
        Optional<People> optional = peoples.stream().filter(e -> Integer.valueOf(e.getAge()) > 20).findAny();
        System.out.println(optional.map(People::getAge).orElse("0"));


    }
}

@Data
@Builder
class People{
    private String name;
    private String age;
}
