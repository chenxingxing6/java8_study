package com.samples.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: lanxinghua
 * Date: 2019/7/29 13:49
 * Desc: lombok 测试
 */
public class LombokTest {
    public static void main(String[] args) {
        Student student = Student.builder().name("lxh").age("20").build();
        System.out.println(student);

        // 修改对象属性
        student = student.toBuilder().name("update").build();
        System.out.println(student);
    }
}


@Data    // get,set,toString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
class Student{
    private String name;
    private String age;
}

