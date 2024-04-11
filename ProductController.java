package com.machine.test.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machine.test.crud.model.CategoryDto;
import com.machine.test.crud.model.ProductDto;
import com.machine.test.crud.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/products")
	public ProductDto createCategory(@RequestBody ProductDto productDto) {

		return productService.creatNewProduct(productDto);
	}
	
	@GetMapping("/products")
	public List<ProductDto> getAllproducts() {

		return productService.getAllproducts();
	}
	
	@GetMapping("/products/{id}")
	public ProductDto getProductById(@PathVariable Integer id) {

		return productService.getProductById(id);
	}
	
	@PutMapping("/products/{id}")
	public ProductDto updateProductById(@PathVariable Integer id, @RequestBody ProductDto product) {
		product.setProdId(id);
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProductById(@PathVariable Integer id) {
		return productService.deleteProduct(id);
	}

}
