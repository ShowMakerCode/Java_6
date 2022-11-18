package com.example.sprslide4.DAO;

import com.example.sprslide4.Commom.StudentMap;
import com.example.sprslide4.Entity.Student;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
@Repository
public class StudentDAO {
    RestTemplate rest = new RestTemplate();
    String url = "https://polyjava6-4528b-default-rtdb.firebaseio.com/student.json";

    private String getUrl(String key){
        return url.replace(".json","/"+key+".json");
    }

    public StudentMap findAll(){
        return rest.getForObject(url,StudentMap.class);
    }

    public Student findByKey(String key){
        return rest.getForObject(getUrl(key),Student.class);
    }

    public String create(Student data){
        HttpEntity<Student> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url,entity,JsonNode.class);
        return resp.get("name").asText();
    }

    public Student update(Student data , String key){
        HttpEntity<Student> entity = new HttpEntity<>(data);
        rest.put(getUrl(key),entity);
        return data;
    }

    public void delete(String key){
        rest.delete(getUrl(key));
    }


}
