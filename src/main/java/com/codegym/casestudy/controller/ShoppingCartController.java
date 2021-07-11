package com.codegym.casestudy.controller;

import com.codegym.casestudy.entity.CartItem;
import com.codegym.casestudy.entity.Product;
import com.codegym.casestudy.service.IProductService;
import com.codegym.casestudy.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        CartItem item = new CartItem();
        if(product != null) {
            item.setId(product.get().getId());
            item.setName(product.get().getName());
//            item.setQuantity(product.get().getQuantity());
            item.setTotalPrice(product.get().getPrice());
//            BeanUtils.copyProperties(product, item);
            item.setQuantity(1L);
            cartService.add(item);

        }
        return "redirect:/shoppingCart/list-cart";
    }


    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id")Long id){
        cartService.remove(id);
        return "redirect:/shoppingCart/list-cart";
    }
    @GetMapping("update/")
    public String update(@RequestParam("id") Long id,
                         @RequestParam("quantity")Long quantity){
        cartService.update(id,quantity);
        return "redirect:/shoppingCart/list-cart";
    }
    @GetMapping("clear")
    public String clear(){
        return "redirect:/shoppingCart/list-cart";
    }
}
