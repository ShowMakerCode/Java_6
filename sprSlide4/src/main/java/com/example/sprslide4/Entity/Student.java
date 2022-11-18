package com.example.sprslide4.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    String email;
    String fullname;
    Double mark;
    Boolean gender;
    String contry;
}
