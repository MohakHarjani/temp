package com.mohak.food_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohak.food_backend.model.Category;


 public interface CategoryRepository extends JpaRepository<Category, Long>{
	 
//	 long deleteById(long categoryId);
	

}
