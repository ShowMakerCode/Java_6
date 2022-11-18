package com.example.lambda_slide1.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class streamTutorial {
    static List<Student> list = Arrays.asList(
            new Student("Nguyen THai Hoang1",true,7.5),
            new Student("Nguyen THai Hoang2",false,8.5),
            new Student("Nguyen THai Hoang3",true,9.5),
            new Student("Nguyen THai Hoang4",true,5.5),
            new Student("Nguyen THai Hoang5",true,6.5)
    );
    public static void main(String[] args) {
//        demo1();
        demo2();

    }

    private static void demo2() {
        List<Student> students = list.stream().filter(student -> student.getName().startsWith("Ha")).collect(Collectors.toList());
        students.forEach(student -> System.out.println(student.getName()));
    }

    private static void demo1() {
        list.stream().filter(vux -> vux.getMarks() <8).forEach(rex->
                System.out.println(rex.getGender())
        );
    }
}
