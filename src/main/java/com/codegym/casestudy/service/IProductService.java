package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Category;
import com.codegym.casestudy.entity.Product;
import com.codegym.casestudy.form.ProductForm;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> searchByName(String name);
    Product converter(ProductForm productForm);
    Iterable<Product> findAllProductByName(String name);
}
