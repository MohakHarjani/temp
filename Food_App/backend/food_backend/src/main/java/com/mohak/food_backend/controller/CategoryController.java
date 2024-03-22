package com.mohak.food_backend.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mohak.food_backend.model.Category;
import com.mohak.food_backend.repository.CategoryRepository;
import com.mohak.food_backend.service.CategoryService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping ("/")
    ResponseEntity<List<Category>> getAllCategories()
	{
		List<Category> foundCategoryList = this.categoryService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(foundCategoryList);
	}
	
	@GetMapping ("/{id}")
	ResponseEntity<Category> getCategory (@PathVariable(value = "id") long categoryId)
	{
		Category foundCategory = this.categoryService.findCategory(categoryId);
		return ResponseEntity.status(HttpStatus.OK).body(foundCategory);
	}
	
	@PostMapping ("/")
    ResponseEntity<Category> postCategory(@Valid @RequestBody Category c)
	{
		Category postedCategory = this.categoryService.postCategory(c);
		return ResponseEntity.status(HttpStatus.CREATED).body(postedCategory);
		
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Object> deleteCategory (@PathVariable long id)
	{
		this.categoryService.deleteCategory(id);
		Map<String, Object>responseMap = new HashMap<String, Object>();
		responseMap.put("message", "Deleted category with id = " + id + " successfully ");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	@PutMapping ("/")
	ResponseEntity<Category> updateCategory (@Valid @RequestBody Category newCategory)
	{
		Category updatedCategory = this.categoryService.updateCategory(newCategory);
		return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
	}
	
	
}
