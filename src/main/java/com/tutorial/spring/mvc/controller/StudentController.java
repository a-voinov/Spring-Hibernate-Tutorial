package com.tutorial.spring.mvc.controller;

import com.tutorial.spring.mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model){
        //create a new student object
        Student student = new Student();
        //add student obj to the model
        model.addAttribute("student", student);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){
        System.out.println("processed: " + student);
        return "student-confirmation";
    }

}
