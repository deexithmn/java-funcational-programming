package com.funcational.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class BehaviorParameterization {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 5, 89, 78, 45, 9, 45, 60, 4);
        Predicate<Integer> even = x -> x % 2 == 0;
        Predicate<Integer> odd = x -> x % 2 != 0;
        System.out.println("========================");
        System.out.println("Fetching all even numbers");
        passBehavior(list, even);
        System.out.println("========================");
        System.out.println("Fetching all odd numbers");
        passBehavior(list, odd);
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> cube = x -> x * x * x;
        System.out.println("========================");
        System.out.println("Square all the numbers");
        passBehaviorWithActionOnNumbers(list, square);
        System.out.println("========================");
        System.out.println("Cube all the numbers");
        passBehaviorWithActionOnNumbers(list, cube);

        System.out.println("========================");
        System.out.println("Supplier Operator");
        Supplier<Integer> supplier = () -> 2;
        System.out.println(supplier.get());

        System.out.println("========================");
        System.out.println("Unary Operator multiplying by 3");
        UnaryOperator<Integer> unaryOperator = (x) -> x*3;
        System.out.println(unaryOperator.apply(10));

        System.out.println("========================");
        System.out.println("BiPredicate Operator to check if sum is greater than 10");
        BiPredicate<Integer, Integer> biPredicate = (x , y) -> (x + y) > 10;
        System.out.println(biPredicate.test(5, 9));


        System.out.println("========================");
        System.out.println("biFunction Operator to check if the sum is greater than 10");
        BiFunction<Integer, Integer, Boolean> biFunction = (x , y) -> (x + y) > 10;
        System.out.println(biFunction.apply(4, 4));


        System.out.println("========================");
        System.out.println("BiConsumer Operator to print the sum of two numbers");
        BiConsumer<Integer, Integer> biConsumer = (x , y) -> {
            System.out.println(x + y);
        };
        biConsumer.accept(4, 12);

    }

    private static void passBehaviorWithActionOnNumbers(List<Integer> list, Function<Integer, Integer> function) {
        list.stream().map(function).forEach(System.out::println);
    }


    private static void passBehavior(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }


}
