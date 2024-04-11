package com.machine.test.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machine.test.crud.entity.Category;
import com.machine.test.crud.entity.Product;
import com.machine.test.crud.model.CategoryDto;
import com.machine.test.crud.model.ProductDto;
import com.machine.test.crud.repository.CategoryRepository;
import com.machine.test.crud.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	public ProductDto creatNewProduct(ProductDto product) {
		
		Category catg = categoryRepository.findByCatgName(product.getCategoryName());
		
		Product prodentity = new Product();
		
		prodentity.setCategory(catg);
		prodentity.setProdDescription(product.getProdDescription());
		prodentity.setProdId(product.getProdId());
		prodentity.setProdName(product.getProdName());
		
		Product savedProduct = productRepository.save(prodentity);
		
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCatgDescription(catg.getCatgDescription());
		categoryDto.setCatgId(catg.getCatgId());
		categoryDto.setCatgName(catg.getCatgName());
		
		ProductDto productDto = new ProductDto();
		productDto.setCategory(categoryDto);
		productDto.setProdDescription(savedProduct.getProdDescription());
		productDto.setProdId(savedProduct.getProdId());
		productDto.setProdName(savedProduct.getProdName());
		
		return productDto;
	}
	

	
		public List<ProductDto> getAllproducts(){
		
		List<Product> prodList = productRepository.findAll();
		List<ProductDto> out = new ArrayList<>();
		
		prodList.forEach(product ->{
			
			ProductDto prodDTo = new ProductDto();
			prodDTo.setProdDescription(product.getProdDescription());
			prodDTo.setProdId(product.getProdId());
			prodDTo.setProdName(product.getProdName());
			prodDTo.setCategoryName(product.getCategory().getCatgName());
			out.add(prodDTo);
		} );
		
		return out;
	}
		public ProductDto getProductById(Integer id) {
			
			Product product = productRepository.findById(id).get();
			
			ProductDto prodDTo = new ProductDto();
			prodDTo.setProdDescription(product.getProdDescription());
			prodDTo.setProdId(product.getProdId());
			prodDTo.setProdName(product.getProdName());
			prodDTo.setCategoryName(product.getCategory().getCatgName());
			
			return prodDTo;
		}
		public ProductDto updateProduct(ProductDto product) {
			Category catg = categoryRepository.findByCatgName(product.getCategoryName());
			
			Product prodDTo = new Product();
			prodDTo.setProdDescription(product.getProdDescription());
			prodDTo.setProdId(product.getProdId());
			prodDTo.setProdName(product.getProdName());
			prodDTo.setCategory(catg);
			
			Product prod = productRepository.save(prodDTo);
			
			ProductDto produDTo = new ProductDto();
			produDTo.setProdDescription(prod.getProdDescription());
			produDTo.setProdId(prod.getProdId());
			produDTo.setProdName(prod.getProdName());
			produDTo.setCategoryName(prod.getCategory().getCatgName());
			
			return produDTo;
		}
		
		public String deleteProduct(Integer id) {
			
			productRepository.deleteById(id);
			 
			 return "SUCCESS";
		}

}
