package com.product.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.rest.bean.Product;
import com.product.rest.repository.ProductRepository;

@Service
public class ProductDao {
	
	@Autowired
	ProductRepository productRepository;
	
	/* To save a product */
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	/* To get all products */
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	/* To get a product by id */
	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}
	
	/* To delete a product By id */
	public void delete(Long id) {
		productRepository.delete(id);
	}
}
