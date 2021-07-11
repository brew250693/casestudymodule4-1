package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
