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
import com.machine.test.crud.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/categories")
	public CategoryDto createCategory(@RequestBody CategoryDto category) {

		return categoryService.creatNewCategory(category);
	}

	@GetMapping("/categories")
	public List<CategoryDto> getAllCategory() {

		return categoryService.getAllCategories();
	}

	@GetMapping("/categories/{id}")
	public CategoryDto getCategoryById(@PathVariable Integer id) {

		return categoryService.getCategoryById(id);
	}

	@PutMapping("/categories/{id}")
	public CategoryDto updateCategoryById(@PathVariable Integer id, @RequestBody CategoryDto category) {
		category.setCatgId(id);
		return categoryService.updateCategory(category);
	}

	@DeleteMapping("/categories/{id}")
	public String deleteCategoryById(@PathVariable Integer id) {
		return categoryService.deleteCategory(id);
	}

}
