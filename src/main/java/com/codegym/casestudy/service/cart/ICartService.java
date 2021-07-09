package com.codegym.casestudy.service.cart;

import com.codegym.casestudy.entity.Orders;
import com.codegym.casestudy.service.IGeneralService;

public interface ICartService extends IGeneralService<Orders> {
    Long getCount();

    Long getAmount();
}
