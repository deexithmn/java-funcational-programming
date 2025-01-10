package com.funcational.programming;

import java.util.List;
import java.util.function.BinaryOperator;

public class FunctionalInterface {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,5,89,78,45,9,45,60,4);

        getSum(list);


    }

    private static void getSum(List<Integer> list) {
        //Using streams

        int sum = list.stream().reduce(0, getSum());
        System.out.println(sum);

        // extracting the method ref
        BinaryOperator<Integer> calSum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        sum = list.stream().reduce(0, calSum);
        System.out.println(sum);


    }

    private static BinaryOperator<Integer> getSum() {
        return Integer::sum;
    }
}
