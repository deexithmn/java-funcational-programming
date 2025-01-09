package com.funcational.programming;

import java.util.ArrayList;
import java.util.List;

public class Sum {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,5,89,78,45,9,45,60,4);
        System.out.println(getSum(list));
        System.out.println("========================");
        System.out.println(findLarge(list));
        System.out.println("========================");
        System.out.println(findSmallest(list));
        System.out.println("========================");
    }

    private static int findSmallest(List<Integer> list) {
        System.out.println("========================");
        System.out.println("Fetching the Lowest in the list!");

        return list.stream().reduce(Integer.MAX_VALUE, Math::min);
    }

    private static int findLarge(List<Integer> list) {
        System.out.println("========================");
        System.out.println("Fetching the Largest in the list!");
        return list.stream().reduce(Integer.MIN_VALUE, Math::max);
    }

    private static int getSum(List<Integer> list) {
        System.out.println("========================");
        System.out.println("Fetching the Sum");
        return list.stream().reduce(0, Integer::sum);
    }
}
