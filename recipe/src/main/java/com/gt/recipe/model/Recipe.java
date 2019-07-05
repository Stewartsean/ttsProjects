package com.gt.recipe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer numOfIngredients;
	private Integer prepTime;
	
	public Recipe() {}
	
	public Recipe(String name, Integer numOfIngredients, Integer prepTime) {
		this.name = name;
		this.numOfIngredients = numOfIngredients;
		this.prepTime = prepTime;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumOfIngredients() {
		return numOfIngredients;
	}
	public void setNumOfIngredients(Integer numOfIngredients) {
		this.numOfIngredients = numOfIngredients;
	}
	public Integer getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", numOfIngredients=" + numOfIngredients + ", prepTime="
				+ prepTime + "]";
	}
}
