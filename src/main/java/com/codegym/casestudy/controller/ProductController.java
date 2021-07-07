package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Product;
import com.codegym.casestudy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/create-product")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create-product");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }


    @PostMapping("/create-product")
    public ModelAndView saveCustomer(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create-product");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }

    @GetMapping("/list-product")
    public ModelAndView showList(){
        return new ModelAndView("/product/list-product","list",productService.findAll());
    }

}

