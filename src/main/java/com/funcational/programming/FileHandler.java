package com.funcational.programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public class FileHandler {

    public static void main(String[] args) throws IOException {
        System.out.println("Print all the distinct words in the file sorted based on the string length");
        Files.lines(Paths.get("src/main/resources/text.txt"))
                .map(c -> c.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }
}
