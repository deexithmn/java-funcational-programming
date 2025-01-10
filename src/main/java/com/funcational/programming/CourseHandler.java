package com.funcational.programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class CourseHandler {

    public static void main(String[] args) {
        List<Course> courseList = List.of(
                new Course(1, "Spring", "Framework", 100),
                new Course(2, "Spring MVC", "Framework", 300),
                new Course(3, "Spring Boot", "Framework", 4500),
                new Course(4, "Java", "Language", 890),
                new Course(5, "NodeJS", "Language", 11500),
                new Course(6, "Docker", "Technology", 4700),
                new Course(7, "k8s", "Technology", 7800),
                new Course(8, "SQL", "Language", 19000),
                new Course(9, "No-SQL", "Language", 19000)
                );
        Predicate<Course> lessThen1kStudents = c -> c.getNoOfStudents() < 1000;
        Predicate<Course> greaterThen1kStudents = c -> c.getNoOfStudents() > 1000;
        Predicate<Course> lessThen100Students = c -> c.getNoOfStudents() < 100;

        //Get all the scores where the number of students registered are more than 1k
        System.out.println("Are all the courses less than 1k registered? " + courseList.stream().allMatch(lessThen1kStudents));
        System.out.println("Do we any course less than 1k student registered? " + courseList.stream().anyMatch(lessThen1kStudents));
        System.out.println("Any courses that are more than 1k? " + courseList.stream().anyMatch(greaterThen1kStudents));
        System.out.println("Any courses that is less then 100? " + courseList.stream().noneMatch(lessThen100Students));

        // Sorting

        Comparator<Course> comparator = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getId).reversed();

        List<Course> sortedCourse = courseList.stream().sorted(comparator).collect(Collectors.toList());
        sortedCourse.stream().forEach(System.out::println);


        System.out.println(courseList.stream().sorted(comparator).filter(lessThen1kStudents).findFirst());

        System.out.println(courseList.stream().sorted(comparator).filter(lessThen1kStudents).findAny());

        System.out.println("Take while limiting to 2");

        System.out.println(courseList.stream().sorted(comparator).takeWhile(lessThen1kStudents).collect(Collectors.toList()));

        System.out.println(courseList.stream().sorted(comparator).dropWhile(lessThen1kStudents).collect(Collectors.toList()));

        System.out.println("Taking last element");
        System.out.println(courseList.stream().max(comparator));

        System.out.println("Taking first element");
        System.out.println(courseList.stream().min(comparator));
        System.out.println("Find the sum of students of the courses where students registered are more than 1000");
        System.out.println(courseList.stream().filter(greaterThen1kStudents).mapToInt(Course::getNoOfStudents).average());

        System.out.println("Group the course based on category");
        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println("Group the course based on category and pull the course with max number of students");
        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getNoOfStudents)))));

        System.out.println("Pull the course name only based on number of students");
        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));

        System.out.println("Creating a stream and printing the first 10 event numbers");
        System.out.println(IntStream.iterate(2, x -> x + 2).limit(10).peek(System.out::println).sum());

        System.out.println("Calculate the power of two");
        System.out.println(DoubleStream.iterate(2, e -> e*2).limit(10).peek(System.out::println).sum());

    }
}
