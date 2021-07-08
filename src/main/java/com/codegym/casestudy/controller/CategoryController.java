package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Category;
import com.codegym.casestudy.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create-category");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }


    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create-category");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }
    @GetMapping("list-category")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/category/list-category");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }
        @GetMapping("/edit-category/{id}")
        public ModelAndView showEditForm(@PathVariable Long id) {
            Optional<Category> category = categoryService.findById(id);
            if (category.isPresent()) {
                ModelAndView modelAndView = new ModelAndView("/category/edit-category");
                modelAndView.addObject("categories", category.get());
                return modelAndView;
            } else {
                return new ModelAndView("/category/error.404");
            }
        }

        @PostMapping("/edit-category")
        public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
            categoryService.save(category);
            ModelAndView modelAndView = new ModelAndView("/category/edit-category");
            modelAndView.addObject("categories", category);
            modelAndView.addObject("message", "Category updated successfully");
            return modelAndView;
        }
        @GetMapping("/delete-category/{id}")
        public ModelAndView showDeleteForm(@PathVariable Long id) {
            Optional<Category> category = categoryService.findById(id);
            if (category.isPresent()) {
                ModelAndView modelAndView = new ModelAndView("/category/delete-category");
                modelAndView.addObject("categories", category.get());
                return modelAndView;

            } else {
                return new ModelAndView("/category/error.404");
            }
        }

        @PostMapping("/delete-category")
        public String deleteCategory(@ModelAttribute("category") Category category) {
            categoryService.remove(category.getId());
            return "redirect:list-category";
        }
    }
