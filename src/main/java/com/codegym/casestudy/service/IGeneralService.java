package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Product;

import java.util.Optional;

public interface IGeneralService <T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    Product save (T t);
    void remove (Long id);

}
