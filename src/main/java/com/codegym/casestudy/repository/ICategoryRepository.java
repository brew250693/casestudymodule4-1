package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Category;
import com.codegym.casestudy.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
