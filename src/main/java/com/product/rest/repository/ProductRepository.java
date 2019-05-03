package com.product.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.rest.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
