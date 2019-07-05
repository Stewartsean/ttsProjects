package com.st.recipe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer numIngredients;
	private Integer prepTime;
	
	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	public Recipe(String name, Integer numIngredients, int prepTime) {
		super();
		this.name = name;
		this.numIngredients = numIngredients;
		this.prepTime = prepTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumIngredients() {
		return numIngredients;
	}

	public void setNumIngredients(Integer numIngredients) {
		this.numIngredients = numIngredients;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

	public Long getId() {
		return id;
	}
}
