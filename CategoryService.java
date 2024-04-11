package com.machine.test.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machine.test.crud.entity.Category;
import com.machine.test.crud.model.CategoryDto;
import com.machine.test.crud.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryDto creatNewCategory(CategoryDto category) {
		
		Category catg = new Category();
		catg.setCatgDescription(category.getCatgDescription());
		catg.setCatgId(category.getCatgId());
		catg.setCatgName(category.getCatgName());
				
		categoryRepository.save(catg);
		
		return category;
	}
	
	public List<CategoryDto> getAllCategories(){
		
		List<Category> catgList = categoryRepository.findAll();
		List<CategoryDto> out = new ArrayList<>();
		
		catgList.forEach(cat ->{
			
			CategoryDto ctgDTo = new CategoryDto();
			ctgDTo.setCatgDescription(cat.getCatgDescription());
			ctgDTo.setCatgId(cat.getCatgId());
			ctgDTo.setCatgName(cat.getCatgName());
			out.add(ctgDTo);
		} );
		
		return out;
	}
	
	public CategoryDto getCategoryById(Integer id) {
	
		Category cat = categoryRepository.findById(id).get();
		
		CategoryDto ctgDTo = new CategoryDto();
		ctgDTo.setCatgDescription(cat.getCatgDescription());
		ctgDTo.setCatgId(cat.getCatgId());
		ctgDTo.setCatgName(cat.getCatgName());
		
		return ctgDTo;
	}
	
	public CategoryDto updateCategory(CategoryDto category) {
		
		Category catg = new Category();
		catg.setCatgDescription(category.getCatgDescription());
		catg.setCatgId(category.getCatgId());
		catg.setCatgName(category.getCatgName());
		
		Category cat = categoryRepository.save(catg);
		
		CategoryDto ctgDTo = new CategoryDto();
		ctgDTo.setCatgDescription(cat.getCatgDescription());
		ctgDTo.setCatgId(cat.getCatgId());
		ctgDTo.setCatgName(cat.getCatgName());
		
		return ctgDTo;
	}
	
	public String deleteCategory(Integer id) {
		
		 categoryRepository.deleteById(id);
		 
		 return "SUCCESS";
	}
	

}
