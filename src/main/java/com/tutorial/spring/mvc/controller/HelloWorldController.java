package com.tutorial.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model){
        model.addAttribute("message", "Yo " + request.getParameter("studentName").toUpperCase());
        return "helloworld";
    }

    @RequestMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String name, Model model){
        model.addAttribute("message", "Yo " + name.toUpperCase());
        return "helloworld";
    }
}
