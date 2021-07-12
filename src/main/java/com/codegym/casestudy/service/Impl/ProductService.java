package com.codegym.casestudy.service.Impl;

import com.codegym.casestudy.entity.Category;
import com.codegym.casestudy.entity.Product;
import com.codegym.casestudy.repository.IProductRepository;
import com.codegym.casestudy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    Environment environment;

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
