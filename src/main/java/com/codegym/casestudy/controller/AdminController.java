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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    @GetMapping("/create-category")
    public ModelAndView showCreateCateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/category/create-category");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/admin/category/create-category");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }
    @GetMapping("list-category")
    public ModelAndView showCateList() {
        ModelAndView modelAndView = new ModelAndView("/admin/category/list-category");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditCateForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/admin/category/edit-category");
            modelAndView.addObject("categories", category.get());
            return modelAndView;
        } else {
            return new ModelAndView("error-404");
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/admin/category/edit-category");
        modelAndView.addObject("categories", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteCateForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/admin/category/delete-category");
            modelAndView.addObject("categories", category.get());
            return modelAndView;

        } else {
            return new ModelAndView("error-404");
        }
    }

    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category) {
        categoryService.remove(category.getId());
        return "redirect:/admin/list-category";
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateProductForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/product/create-product");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return (List<Category>) categoryService.findAll();
    }

    @PostMapping("/create-product")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/admin/product/create-product");
        modelAndView.addObject("categories",categoryService.findAll());
        modelAndView.addObject("products", new Product());
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }

    @GetMapping("/list-product")
    public ModelAndView showListProduct() {
        ModelAndView modelAndView = new ModelAndView("/admin/product/list-product");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditProductForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/admin/product/edit-product");
            modelAndView.addObject("products", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("error-404");
        }
    }

    @PostMapping("/edit-product")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/admin/product/edit-product");
        modelAndView.addObject("products", product);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteProductForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/admin/product/delete-product");
            modelAndView.addObject("products", product.get());
            return modelAndView;

        } else {
            return new ModelAndView("error-404");
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        productService.remove(product.getId());
        return "redirect:/admin/list-product";
    }
}
