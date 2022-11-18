package com.example.lambda_slide1.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Student{
     String name;
     Boolean gender =false;
     Double marks;
     Contact contact;
     String[] subjects;


}
