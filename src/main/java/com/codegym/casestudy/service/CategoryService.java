package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Category;
import com.codegym.casestudy.repository.ICategoryRepo;
import com.codegym.casestudy.repository.IProductRepository;
import com.codegym.casestudy.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {


    @Autowired
    private ICategoryRepo repository;
    @Override
    public Iterable<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Category category) {
repository.save(category);
    }

    @Override
    public void remove(Long id) {
repository.deleteById(id);
    }
}
