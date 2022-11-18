package com.example.sprslide4.controller;

import com.example.sprslide4.Commom.StudentMap;
import com.example.sprslide4.DAO.StudentDAO;
import com.example.sprslide4.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("student")
public class MyController {
    @Autowired
    StudentDAO dao;

    @RequestMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("form", new Student());
        StudentMap items = dao.findAll();
        model.addAttribute("items", items);
        return "site/homepage";
    }

    @RequestMapping("edit/{key}")
    public String edit(Model model, @PathVariable("key") String key) {
        model.addAttribute("key", key);
        Student student = dao.findByKey(key);
        model.addAttribute("form", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        return "site/homepage";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("form") Student student) {
        dao.create(student);
        return "redirect:/student/index";
    }

    @PostMapping("update/{key}")
    public String update(@PathVariable("key") String key, @ModelAttribute("form") Student student) {
        dao.update(student, key);
        return "redirect:/student/index";
    }

    @RequestMapping("delete/{key}")
    public String delete(@PathVariable("key") String key) {
        dao.delete(key);
        return "redirect:/student/index";
    }

}
