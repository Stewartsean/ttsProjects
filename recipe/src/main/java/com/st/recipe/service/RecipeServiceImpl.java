package com.st.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.recipe.model.Recipe;
import com.st.recipe.repository.RecipeRepository;
@Service
public class RecipeServiceImpl implements RecipeServiceInt {
	@Autowired
	RecipeRepository recipeRepository;

	@Override
	public List<Recipe> findAll() {
		return recipeRepository.findAll();
	}

	@Override
	public Recipe findByName(String name) {
		return recipeRepository.findRecipeByName(name);
	}

	public void saveRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}
	@Override
	public void deleteAll()
	{
		recipeRepository.deleteAll();
	}
	@Override
	public Recipe findRecipeById(Long id) {
		return recipeRepository.findRecipeById(id);
	}
}
