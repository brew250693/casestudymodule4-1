package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.Orders;
import com.codegym.casestudy.service.cart.CartService;
import com.codegym.casestudy.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/cart")
    public ModelAndView cartView() {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cartService.findAll());
        return modelAndView;
    }

    @GetMapping("/cart/update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        Optional<Orders> orders = cartService.findById(id);
        if (orders.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/cart");
            modelAndView.addObject("cart", orders.get());
            return modelAndView;
        } else {
            return new ModelAndView("/product/error.404");
        }
    }

    @GetMapping("/cart/remove/{id}")
    public ModelAndView remove(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        cartService.remove(id);
        sessionService.set("countProduct", cartService.getCount());
        return modelAndView;
    }
}
