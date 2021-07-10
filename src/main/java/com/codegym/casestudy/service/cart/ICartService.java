package com.codegym.casestudy.service.cart;

import com.codegym.casestudy.entity.CartItem;
import com.codegym.casestudy.service.IGeneralService;

public interface ICartService extends IGeneralService<CartItem> {
    Long getCount();

    Long getAmount();
}
