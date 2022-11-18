package com.example.lambda_slide1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String username;
    String password;
    String fullname;
    String email;
    Boolean gender;
    Date birthday ;
    Double schoolfee;
    Double marks;

}
