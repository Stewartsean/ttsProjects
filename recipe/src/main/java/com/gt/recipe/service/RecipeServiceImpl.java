package com.gt.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.recipe.model.Recipe;
import com.gt.recipe.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeServiceInt{
	@Autowired
	RecipeRepository recipeRepository;

	@Override
	public Recipe findByName(String name) {
		return recipeRepository.findRecipeByName(name);
	}

	@Override
	public List<Recipe> findAll() {
		return recipeRepository.findAll();
	}

	@Override
	public void saveRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}
}
