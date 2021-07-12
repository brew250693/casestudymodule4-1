package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
    @Query(nativeQuery = true,value = "select * from products where shop_id = ?")
    List<Product> findProductByShop_Id(Long id);

    Iterable<Product> findProductByName(String name);
}
