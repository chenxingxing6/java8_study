package com.samples.misc;

import java.lang.annotation.*;

/**
 * User: lanxinghua
 * Date: 2019/7/30 14:08
 * Desc: java8 新增注解 @Repeatable  同一种注解多次使用时
 *
 * @Target     // 注解的修饰目标  type【类，接口，枚举】,field,method,parameter,constructor,local_variable,annotation_type,package
 * @Retention  // 生命周期  source,class(默认),runtime
 * @Documented // 这个注解被javadoc工具记录
 * @Inherited  // 允许子类继承父类的注解
 */
public class AnnotationsTest {
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @interface MyAnnotation{

    }

    @Repeatable(Hints.class)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Hint {
        String value() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Hints {
        Hint[] value();
    }

    @Hint("hint1")
    @Hint("hint2")
    class Person{

    }

    public static void main(String[] args) {
        Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);

        // 标记多个注解
        Hints hints = Person.class.getAnnotation(Hints.class);
        System.out.println(hints.value().length);
    }


}
