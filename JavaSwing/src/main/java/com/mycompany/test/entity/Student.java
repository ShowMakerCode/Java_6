/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 98tae
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String contry;
    private String email;
    private String fullname;
    private Boolean gender;
    private Double mark;

    @JsonIgnore
    public Object[] getArray() {
        return new Object[]{
            getEmail(),
            getFullname(),
            getMark(),
            getGender(),
            getContry()
        };
    }
}
