package com.gt.recipe.service;

import java.util.List;

import com.gt.recipe.model.Recipe;

public interface RecipeServiceInt {
	public Recipe findByName(String name);
	public List<Recipe> findAll();
	public void saveRecipe(Recipe recipe);
}
