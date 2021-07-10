package com.codegym.casestudy.service.cart;

import com.codegym.casestudy.entity.CartItem;
import com.codegym.casestudy.service.IGeneralService;

import java.util.Collection;

public interface ICartService {
    void add(CartItem item);

    void remove(long id);

    Collection<CartItem> getCartItems();

    void clear();

    void update(long id, long quantity);

    double getAmount();

    int getCount();
}
