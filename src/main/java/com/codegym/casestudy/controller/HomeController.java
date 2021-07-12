package com.codegym.casestudy.controller;

import com.codegym.casestudy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private IProductService productService;

    @GetMapping("/user-home")
    public String userHomePage() {
        return "/user/user-home";
    }

    @GetMapping("/admin-home")
    public String adminHomePage() {
        return "/admin/admin-home";
    }

    @GetMapping("/product-detail")
    public String productDetailPage() {
        return "/product-detail";
    }

    @GetMapping("/product-list")
    public String productListPage() {
        return "/product-list";
    }

    @GetMapping("/error-404")
    public String error404Page() {
        return "error-404";
    }

    @GetMapping("/error-403")
    public String error403Page() {
        return "error-403";
    }
}
