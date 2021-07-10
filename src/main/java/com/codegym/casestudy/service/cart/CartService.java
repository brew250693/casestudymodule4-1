package com.codegym.casestudy.service.cart;

import com.codegym.casestudy.entity.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Service
@SessionScope
public class CartService implements ICartService {
    private Map<Long, CartItem> map = new HashMap<Long, CartItem>();

    @Override
    public void add(CartItem item) {
        CartItem existedItem = map.get(item.getId());
        if (existedItem != null) {
            existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
        } else {
        }
        map.put(item.getId(), item);
    }

    @Override
    public void remove(long id) {
        map.remove(id);
    }

    @Override
    public Collection<CartItem> getCartItems() {
        return map.values();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public void update(long id, long quantity) {
        CartItem item = map.get(id);
        item.setQuantity(quantity + item.getQuantity());
        if (item.getQuantity() <= 0) {
            map.remove(id);
        }
    }
    @Override
    public double getAmount(){
        return map.values().stream().mapToDouble(product->product.getQuantity() * product.getTotalPrice()).sum();
    }
    @Override
    public int getCount(){
        if(map.isEmpty())
            return 0;
        return map.values().size();
    }
}
