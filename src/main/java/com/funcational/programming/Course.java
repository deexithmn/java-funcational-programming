package com.funcational.programming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Course {
    int id;
    String name;
    String category;
    int noOfStudents;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}
