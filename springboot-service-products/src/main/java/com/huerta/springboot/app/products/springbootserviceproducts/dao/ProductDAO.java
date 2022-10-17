package com.huerta.springboot.app.products.springbootserviceproducts.dao;

import org.springframework.data.repository.CrudRepository;

import com.huerta.springboot.app.products.springbootserviceproducts.models.entity.Product;

public interface ProductDAO extends CrudRepository<Product, Long> {}
