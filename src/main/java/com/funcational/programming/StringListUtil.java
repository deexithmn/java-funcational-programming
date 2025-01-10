package com.funcational.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListUtil {

    public static void main(String[] args) {
        List<String> courses = List.of("Docker", "Spring", "Spring Boot", "API", "Maven", "k8s", "Kafka", "Spring MVC");

        System.out.println("Print all the courses");
        System.out.println(courses.stream().collect(Collectors.joining(" ")));

        System.out.println("Split all the characters into individual chars");
        System.out.println(courses.stream().map(str -> str.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));

        System.out.println("Create a list of list grouping the charter length in the course");
        System.out.println(courses.stream().flatMap(c -> courses.stream().filter(c2 -> c.length() == c2.length()).map(cz -> List.of(c, cz))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));

        System.out.println("Get courses whose length is grater than a number and the upper case them");

        System.out.println(courses.stream().parallel().filter(c -> c.length() > 5).map(String::toUpperCase).findFirst());

        System.out.println("Replace the strings to upper case");
        ArrayList<String> mutableCourse = new ArrayList(courses);
        mutableCourse.replaceAll(str -> str.toUpperCase());
        mutableCourse.stream().forEach(System.out::println);

        System.out.println("Remove all the courses that have length below 6");

        mutableCourse.removeIf(str -> str.length() < 6);
        System.out.println(mutableCourse);
    }
}
