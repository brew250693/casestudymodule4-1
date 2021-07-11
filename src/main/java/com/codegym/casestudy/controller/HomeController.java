package com.codegym.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/user-home")
    public String userHomePage() {
        return "/user/user-home";
    }

    @GetMapping("/admin-home")
    public String adminHomePage() {
        return "/admin/admin-home";
    }

    @GetMapping("/product-detail")
    public String productDetailPage() {return "/product-detail";}

    @GetMapping("/product-list")
    public String productListPage() {return "/product-list";}
}
