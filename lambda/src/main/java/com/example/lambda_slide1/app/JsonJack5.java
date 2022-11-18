package com.example.lambda_slide1.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonJack5 {
    public static void main(String[] args) throws IOException {
//    demo1();
    demo2();
    }

    private static void demo2() throws IOException {
        String json ="F:\\java 6\\lambda_Slide1\\src\\main\\resources\\listUser.json";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode nodes = objectMapper.readTree(new File(json));
        nodes.iterator().forEachRemaining(st -> System.out.println(st.get("username").asText()));

    }

    private static void demo1() throws IOException {
        String json = "F:\\java 6\\lambda_Slide1\\src\\main\\resources\\student.json";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode student = objectMapper.readTree(new File(json));
        System.out.println("Name : " + student.get("name").asText());
        student.get("subjects").iterator().forEachRemaining(sub-> System.out.println(sub.asText()));

    }


}
