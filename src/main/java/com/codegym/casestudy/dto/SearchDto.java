package com.codegym.casestudy.dto;

import com.codegym.casestudy.entity.Product;

import java.util.List;

public class SearchDto {
    private List<Product> productList;


    public SearchDto() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }





    @Override
    public String toString() {
        return "SearchDto{" +
                "productList=" + productList +
                '}';
    }
}
