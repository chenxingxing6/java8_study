package com.samples.lambda;

/**
 * User: lanxinghua
 * Date: 2019/7/30 11:07
 * Desc: 函数式编程
 */
public class InterfaceTest1 {

    interface Formula {
        double calculate(int a);

        default double sqrt(int a){
            return Math.sqrt(positive(a));
        }
        static int positive(int a){
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return a + 100;
            }
        };
        System.out.println(formula1.calculate(100));

        System.out.println(formula1.sqrt(-100));

        // 函数实现接口
        Formula formula2 = (o) -> {
            return o + 10;
        };
        System.out.println(formula2.calculate(1));

    }
}
