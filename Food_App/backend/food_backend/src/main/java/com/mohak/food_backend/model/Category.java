package com.mohak.food_backend.model;


import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	Long id;
	
//	@Column (nullable = false) //sql validation 
	@NotBlank(message = "Name cannot be blank")  //for this add "spring-boot-starter-validation" depend.. in POM
	String name;
	
	@Size (min = 10, message = "Description must have atleast 10 characters")
	String description;
	
	String imgUrl;
	
	LocalDateTime created_at;
	
	public Category ()
	{
		
	}
	
	//================================================================================================


	public Category(Long id, String name, String description, String imgUrl, LocalDateTime created_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.created_at = created_at;
	}

	
	//===============================================================================================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	//======================================================================================
	

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", desc=" + description + ", imgUrl=" + imgUrl + ", created_at="
				+ created_at + "]";
	}


	
	
	
}
