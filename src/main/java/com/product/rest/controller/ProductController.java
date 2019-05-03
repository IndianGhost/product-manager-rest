package com.product.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.rest.bean.Product;
import com.product.rest.dao.ProductDao;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	/* To save a product */
	@PostMapping("/")
	public Product createProduct(Product product) {
		return productDao.save(product);
	}
	
	/* To get all products */
	@GetMapping("/")
	public List<Product> getProducts(){
		return productDao.findAll();
	}
	
	/* To get a product by id */
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable(value = "id") Long id) {
		return productDao.findOne(id);
	}
	
	/* To update a product by id */
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProductById(
			@PathVariable(value = "id") Long id,
			@Valid @RequestBody Product productDetails
			){
		Product product = productDao.findOne(id);
		if(product == null)
			return ResponseEntity.notFound().build();
		
		product.setDesignation(productDetails.getDesignation());
		product.setUnitPrice(productDetails.getUnitPrice());
		product.setAvailableQuantity(productDetails.getAvailableQuantity());
		
		Product updateProduct = productDao.save(product);
		return ResponseEntity.ok().body(updateProduct);
	}
	
	/* Delete a Product by id */
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable(value = "id") Long id) {
		
		Product product = productDao.findOne(id);
		
		if(product == null)
			return ResponseEntity.notFound().build();
		
		productDao.delete(id);
		return ResponseEntity.ok().build();
	}
}
