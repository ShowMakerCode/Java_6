package com.example.lambda_slide1.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    static List<Student> list = Arrays.asList(
            new Student("Nguyen THai Hoang1",true,7.5),
            new Student("Nguyen THai Hoang2",false,8.5),
            new Student("Nguyen THai Hoang3",true,9.5),
            new Student("Nguyen THai Hoang4",true,5.5),
            new Student("Nguyen THai Hoang5",true,6.5)
    );
    public static void main(String[] args) {
//     demo1();
//        demo3();
        demo4();
    }

    private static void demo4() {
        double diemtb = list.stream().mapToDouble(sv-> sv.getMarks()).average().getAsDouble();
        System.out.println("diem tb :" + diemtb);
        double tongdiem = list.stream().mapToDouble(sv -> sv.getMarks()).sum();
        System.out.println("diem tong : "+tongdiem);
        boolean tatcaPass = list.stream().allMatch(sv-> sv.getMarks()>=5);
        System.out.println("pass : " + tatcaPass);
        Student minsv = list.stream().reduce(list.get(0),(min,sv)->sv.getMarks()< min.getMarks()? sv : min);
        System.out.println("Sinh vien diem thap nhat :"+ minsv.getName());

    }

    private static void demo3() {
        List<Student> resList = list.stream().filter(sv->sv.getMarks()>7).collect(Collectors.toList());
        resList.forEach(sv-> {
            System.out.println(sv.getName());
            System.out.println(sv.getMarks());
        });
    }

    private static void demo1() {
        List<Integer> list = Arrays.asList(1,9,4,7,5,2);
        List<Double> result = list.stream()
                .filter(n->n%2==0)
                .map(n-> Math.sqrt(n))
                .peek(d-> System.out.println(d))
                .collect(Collectors.toList());
        System.out.println(result.size());

    }
}
