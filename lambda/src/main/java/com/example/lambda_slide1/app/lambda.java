package com.example.lambda_slide1.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class lambda {
            static List<Student> list = Arrays.asList(
            new Student("Nguyen THai Hoang1",true,7.5),
            new Student("Nguyen THai Hoang2",false,8.5),
            new Student("Nguyen THai Hoang3",true,9.5),
            new Student("Nguyen THai Hoang4",true,5.5),
            new Student("Nguyen THai Hoang5",true,6.5)
    );
    public static void main(String[] args) {
        demo2();
    }

    private static void demo4() {
       Demo4Inter demo4Inter = (x -> {
           System.out.println(x);
       });
       demo4Inter.m1(0);

    }

    private static void demo3() {
        Collections.sort(list,(sv1,sv2)->sv1.getMarks().compareTo(sv2.getMarks()));
        list.forEach(sv ->{
            System.out.println(sv.getName());
            System.out.println(sv.getMarks());
        });
    }

    private static void demo2() {
        list.forEach(sv ->{
            System.out.println(sv.getName());
            System.out.println(sv.getMarks());
            System.out.println(sv.getGender()==true?"Nam":"Nu");
        });
    }

    @FunctionalInterface
    interface  Demo4Inter{
        void m1(int x);
        default void m2(){}
        public static void m3(){}
    }
}
