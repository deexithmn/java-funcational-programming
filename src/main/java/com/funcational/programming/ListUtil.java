package com.funcational.programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,5,89,78,45,9,45,60,4);
        List<String> courses = List.of("Docker", "Spring", "Spring Boot", "API", "Maven", "k8s", "Kafka", "Spring MVC");
        System.out.println(getSum(list));
        System.out.println("========================");
        System.out.println(findLarge(list));
        System.out.println("========================");
        System.out.println(findSmallest(list));
        System.out.println("========================");
        System.out.println(findSumOfSquares(list));
        System.out.println("========================");
        System.out.println(findSumOfCubes(list));
        System.out.println("========================");
        sortTheList(list);
        System.out.println("========================");
        findDistinctList(list);
        System.out.println("========================");
        sortCoursesInOrder(courses);
        System.out.println("========================");
        sortCoursesInReverseOrder(courses);
        System.out.println("========================");
        sortCoursesBasedOnLength(courses);
        System.out.println("========================");
        System.out.println(extractListOfLengthFromCourses(courses));
        System.out.println("========================");
        System.out.println(extractEvenNumberSquares(list));
        System.out.println("========================");
    }

    private static List<Integer> extractEvenNumberSquares(List<Integer> list) {
        System.out.println("Extracting the even number squares");
        return list.stream().filter(x -> x % 2 ==0 ).sorted().map(x -> x*x).collect(Collectors.toList());
    }

    private static List<Integer> extractListOfLengthFromCourses(List<String> courses) {
        System.out.println("Extracting length of the courses");
        return courses.stream().map(String::length).sorted().collect(Collectors.toList());
    }

    private static void sortCoursesBasedOnLength(List<String> courses) {
        System.out.println("Sorting the courses based on string length");
        courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    private static void sortCoursesInReverseOrder(List<String> courses) {
        System.out.println("Sorting the courses in reverser Order");
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void sortCoursesInOrder(List<String> courses) {
        System.out.println("Sorting the courses in Order");
        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    private static void findDistinctList(List<Integer> list) {
        System.out.println("Printing the distinct value");
        list.stream().distinct().forEach(System.out::println);
    }

    private static void sortTheList(List<Integer> list) {
        System.out.println("Printing the sorted9 value");
        list.stream().sorted().forEach(System.out::println);
    }

    private static int findSumOfCubes(List<Integer> list) {
        System.out.println("Fetching the sum of cubes");
        return list.stream().map(x -> x*x*x).reduce(0, Integer::sum);
    }

    private static int findSumOfSquares(List<Integer> list) {
        System.out.println("Fetching the sum of squares!");
//        System.out.println(list.stream().map(x -> x*x).reduce(0, Integer::sum));
        return list.stream().reduce(0, (x, y) -> x + y*y);
    }



    private static int findSmallest(List<Integer> list) {
        System.out.println("Fetching the Lowest in the list!");
        return list.stream().reduce(Integer.MAX_VALUE, Math::min);
    }

    private static int findLarge(List<Integer> list) {
        System.out.println("Fetching the Largest in the list!");
        return list.stream().reduce(Integer.MIN_VALUE, Math::max);
    }

    private static int getSum(List<Integer> list) {
        System.out.println("Fetching the Sum");
        return list.stream().reduce(0, Integer::sum);
    }
}
