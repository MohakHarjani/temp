package com.mohak.food_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mohak.food_backend.exception.ResourceNotFoundException;
import com.mohak.food_backend.model.Category;
import com.mohak.food_backend.repository.CategoryRepository;

@Component
public class CategoryService {
	
	@Autowired
	CategoryRepository cr;
	
	public List<Category> getAll()
	{
		return cr.findAll();
		
	}
	
	public Category postCategory(Category c)
	{
	   return cr.save(c);
	}
	
	public Category findCategory (long categoryId)
	{
		Optional<Category> op =  cr.findById(categoryId);
		if (op.isPresent())
			return op.get();
		else
			throw new ResourceNotFoundException("Category with id = " + categoryId + " not found ");
	}
	
	public void deleteCategory (long categoryId)
	{
		//=============================================================
		try {
		  findCategory(categoryId);
		}
		catch(ResourceNotFoundException ex)
		{
			ex.setMessage(ex.getMessage() + " so it cannot be deleted ");
			throw ex;
		}
		//==================================================================
		cr.deleteById(categoryId);
	}
	
	public Category updateCategory (Category newCategory)
	{
		return this.cr.save(newCategory);
	}
}
