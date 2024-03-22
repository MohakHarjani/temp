package com.mohak.food_backend.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Dish {
	
	@Id
	@GeneratedValue
	long id;
	
	@NotBlank
	String name;
	
	@Size(min = 10, message = "Description must have atleast 10 characters")
	String description;
	
	String imgUrl;
	
	@Min(value = 10, message = "Price must be atleast 10")
	@Max (value = 5000, message = "Price must be at most 5000" )
	float price;
	
//	Category category;
	
	boolean isAvailable;
	

}
