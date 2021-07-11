package com.codegym.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String userHomePage() {
        return "/index";
    }

    @GetMapping("/adminHome")
    public String adminHomePage() {
        return "/admin/adminHome";
    }
}
