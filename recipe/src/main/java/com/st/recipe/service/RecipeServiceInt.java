package com.st.recipe.service;

import java.util.List;

import com.st.recipe.model.Recipe;

public interface RecipeServiceInt 
{
	public List<Recipe> findAll();
	public Recipe findByName(String name);
	public void deleteAll();
	public Recipe findRecipeById(Long id);
}
