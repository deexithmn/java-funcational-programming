package com.funcational.programming;

import java.util.List;

public class LoopNumbers {

    public static void main(String[] args) {
        List<Integer> list = List.of(12,45,7,8,4,8,20,16,78);
        printNumbers(list);
        printEvenNumbers(list);
        printOddNumbers(list);
        List<String> courses = List.of("Docker", "Spring", "Spring Boot", "API", "Maven", "k8s", "Kafka", "Spring MVC");
        printAllStrings(courses);
        printSpringStrings(courses);
        printStringsWithLeastOfFourChars(courses);
        printSquaresOfNumbers(list);
        printCubesOfNumbers(list);
        printNumberOfChars(courses);

    }

    private static void printSquaresOfNumbers(List<Integer> list) {
        System.out.println("Printing squares of numbers");
        System.out.println("========================");
        list.stream().map(x -> x*x).forEach(System.out::println);
        System.out.println("========================");
    }

    private static void printCubesOfNumbers(List<Integer> list) {
        System.out.println("Printing cubes of numbers");
        System.out.println("========================");
        list.stream().map(x -> x*x*x).forEach(System.out::println);
        System.out.println("========================");
    }

    private static void printNumberOfChars(List<String> courses) {
        System.out.println("Printing number of chars in the course");
        System.out.println("========================");
        courses.stream().map(String::length).forEach(System.out::println);
        System.out.println("========================");
    }

    private static void printAllStrings(List<String> courses) {
        System.out.println("Printing all strings");
        System.out.println("========================");
        courses.stream().forEach(System.out::println);
        System.out.println("========================");
    }

    private static void printSpringStrings(List<String> courses) {
        System.out.println("Printing Spring strings only");
        System.out.println("========================");
        courses.stream().filter(str -> str.contains("Spring")).forEach(System.out::println);
        System.out.println("========================");
    }

    private static void printStringsWithLeastOfFourChars(List<String> courses) {
        System.out.println("Printing with least of four chars");
        System.out.println("========================");
        courses.stream().filter(str -> str.length() >= 4).forEach(System.out::println);
        System.out.println("========================");
    }

    private static void printOddNumbers(List<Integer> list) {
        System.out.println("Printing all out numbers");
        System.out.println("========================");
        list.stream().filter(num -> num % 2 != 0).forEach(System.out::println);
        System.out.println("========================");
    }

    private static void printEvenNumbers(List<Integer> list) {
        System.out.println("Printing all even numbers");
        System.out.println("========================");
        list.stream().filter(v -> v%2==0).forEach(System.out::println);
        System.out.println("========================\"");
    }

    private static void printNumbers(List<Integer> list) {
        System.out.println("Printing all the numbers");
        System.out.println("========================");
        list.forEach(System.out::println);
        System.out.println("========================");
    }
}
