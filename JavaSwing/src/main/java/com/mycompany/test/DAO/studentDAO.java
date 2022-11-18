/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test.DAO;

import bean.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.test.entity.Student;
import connection.Rest;

/**
 *
 * @author 98tae
 */
public class studentDAO {
    ObjectMapper objectMapper = new ObjectMapper();
    public StudentMap findALL(){
        JsonNode resp = Rest.get("/student");
        return objectMapper.convertValue(resp, StudentMap.class);
    }
    public Student findByKey(String key){
    JsonNode resp = Rest.get("/student/"+key);
    return objectMapper.convertValue(resp, Student.class);
    }
    public String create(Student data){
    JsonNode resp = Rest.post("/student", data);
    return resp.get("name").asText();
    }
    public Student update(String key , Student data){
    JsonNode resp = Rest.put("/student/"+key, data);
    return objectMapper.convertValue(resp, Student.class);
    }
    public void delete(String key){
    Rest.delete("/student/"+key);
    }
    
}
