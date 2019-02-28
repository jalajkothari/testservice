package com.jk.testservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jk.testservice.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
