package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Category;
import com.codegym.casestudy.entity.Product;
import com.codegym.casestudy.service.ICategoryService;
import com.codegym.casestudy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create-product")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create-product");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }


    @ModelAttribute("categories")
    public List<Category> categories(){
        return (List<Category>) categoryService.findAll();
    }

    @PostMapping("/create-product")
    public ModelAndView saveCustomer(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create-product");
        modelAndView.addObject("categories",categoryService.findAll());
        modelAndView.addObject("products", new Product());
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }

    @GetMapping("/list-product")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("product/list-product");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/product/edit-product");
            modelAndView.addObject("products", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("/product/error.404");
        }
    }

    @PostMapping("/edit-product")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/edit-product");
        modelAndView.addObject("products", product);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/product/delete-product");
            modelAndView.addObject("products", product.get());
            return modelAndView;

        } else {
            return new ModelAndView("/product/error.404");
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        productService.remove(product.getId());
        return "redirect:list-product";
    }

}

