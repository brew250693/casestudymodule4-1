package com.codegym.casestudy.service.cart;

import com.codegym.casestudy.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class CartService implements ICartService {
    public static Map<Long, CartItem> ordersMap = new HashMap<>();

    @Override
    public Iterable<CartItem> findAll() {
        return ordersMap.values();
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return Optional.ofNullable(ordersMap.get(id));
    }

    @Override
    public void save(CartItem cartItem) {
        ordersMap.put(cartItem.getId(), cartItem);
    }

    @Override
    public void remove(Long id) {
        ordersMap.remove(id);
    }

    @Override
    public Long getCount() {
        long count = 0;
        Set<Long> set = ordersMap.keySet();
        for (Long l : set) {
            count++;
        }
        return count;
    }

    @Override
    public Long getAmount() {
        long amount = 0;
        Set<Long> set = ordersMap.keySet();
        for (Long l : set) {
            amount += ordersMap.get(l).getTotalPrice();
        }
        return amount;
    }
}
