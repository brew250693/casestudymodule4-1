package com.codegym.casestudy.controller;

import com.codegym.casestudy.service.ICategoryService;
import com.codegym.casestudy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list-cart")
    public ModelAndView showListCart() {
        ModelAndView modelAndView = new ModelAndView("list-cart");
        modelAndView.addObject("cart", productService.findAll());
        return modelAndView;
    }
}
