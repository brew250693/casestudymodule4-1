package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Product;
import com.codegym.casestudy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IProductService productService;

    @GetMapping("/product-list")
    public ModelAndView showListProduct() {
        ModelAndView modelAndView = new ModelAndView("/user/user-product-list");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/product-detail/{id}")
    public ModelAndView showListProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/user/user-product-detail");
            modelAndView.addObject("products", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("error-404");
        }
    }

    @GetMapping("/edit-profile")
    public ModelAndView editProfile() {
        ModelAndView modelAndView = new ModelAndView("/user/user-edit-profile");
        return modelAndView;
    }

    @GetMapping("/change-pass")
    public ModelAndView changePass() {
        ModelAndView modelAndView = new ModelAndView("/user/user-change-pass");
        return modelAndView;
    }
}
