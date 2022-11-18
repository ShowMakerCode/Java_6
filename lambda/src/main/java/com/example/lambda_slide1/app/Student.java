package com.example.lambda_slide1.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Boolean gender = false;
    private Double marks=0.0;
}
