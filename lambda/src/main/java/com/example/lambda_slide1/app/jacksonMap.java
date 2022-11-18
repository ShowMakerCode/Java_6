package com.example.lambda_slide1.app;

import com.example.lambda_slide1.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class jacksonMap {
    public static void main(String[] args) throws IOException {
//    demo();// mo ta doi tuong
//        demo2();// mo ta doi tuong
        demo3();
//        demo4();
    }

    private static void demo4() throws IOException {
        String file = "F:\\java 6\\lambda_Slide1\\src\\main\\resources\\listUser.json";
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> type = new TypeReference<List<User>>(){};
        List<User> list = objectMapper.readValue(new File(file),type);
        list.forEach(student -> {
            System.out.println(student.getFullname());
        });
    }

    private static void demo3() throws IOException {
        String file = "src/main/resources/static/student.json";
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType valueType = objectMapper.constructType(Student.class);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Student student = objectMapper.readValue(new File(file),valueType);
        System.out.println(student);
    }

    private static void demo2() throws IOException {
        String json = "src/main/resources/listUser.json";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> list = objectMapper.readValue(new File(json),List.class);
        list.forEach(x-> System.out.println(x.get("username")));
    }

    private static void demo() throws IOException {
        String Json = "\\src\\main\\resources\\static\\student.json";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> student = objectMapper.readValue(new File(Json),Map.class);
        System.out.println(student.get("name"));
        Map<String,Object> contact = (Map<String, Object>) student.get("contact");
        System.out.println(contact.get("email"));
        System.out.println(contact.get("phone"));
        List<String> subject = (List<String>) student.get("subjects");
        subject.forEach(x -> System.out.println(x));
    }

}
