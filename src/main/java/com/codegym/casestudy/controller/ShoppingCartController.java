package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.CartItem;
import com.codegym.casestudy.entity.Product;
import com.codegym.casestudy.service.IProductService;
import com.codegym.casestudy.service.cart.ICartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICartService cartService;

    @GetMapping("/list-cart")
    public String list(Model model){
        Collection<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems",cartItems);
        model.addAttribute("total",cartService.getAmount());
        model.addAttribute("NoOfItems",cartService.getCount());
        return "shoppingCarts/list-cart";
    }
    @GetMapping("add/{id}")
    public String add(@PathVariable("id")Long id){
        Optional<Product> product = productService.findById(id);
        if(product != null) {
            CartItem item = new CartItem();
            BeanUtils.copyProperties(product, item);
            item.setQuantity(1L);
            cartService.add(item);

        }
        return "redirect:/shoppingCart/list-cart";
    }


    @GetMapping("remove")
    public String remove(){
        return "redirect:/shoppingCart/list-cart";
    }
    @GetMapping("update")
    public String update(){
        return "redirect:/shoppingCart/list-cart";
    }
    @GetMapping("clear")
    public String clear(){
        return "redirect:/shoppingCart/list-cart";
    }
}
