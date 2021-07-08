package com.codegym.casestudy.service.Impl;

import com.codegym.casestudy.entity.Category;
import com.codegym.casestudy.repository.ICategoryRepository;
import com.codegym.casestudy.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {


    @Autowired
    private ICategoryRepository repository;

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
