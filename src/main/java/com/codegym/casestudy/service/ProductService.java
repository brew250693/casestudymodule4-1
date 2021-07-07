package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Product;
import com.codegym.casestudy.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository repository;
    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }
    @Override
    public void remove(Long id) {
        repository.deleteById(id);

    }
}
