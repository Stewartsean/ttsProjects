package com.st.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.st.recipe.model.Recipe;
import com.st.recipe.service.RecipeServiceImpl;

@Controller
public class RecipeController
{
	@Autowired
	RecipeServiceImpl recipeService;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/recipes")
	public String getAllRecipes(Recipe recipe, Model model)
	{
		List<Recipe> recipeList = recipeService.findAll();
//		model.addAttribute("recipe", recipeList);
		model.addAttribute("recipeList", recipeList);
		return "allRecipes";
	}
	@GetMapping("/recipe/{id}")
	public String getRecipeById(@PathVariable Long id, Model model)
	{
		Recipe recipeId = recipeService.findRecipeById(id);
//		model.addAttribute("recipe", recipeList);
		model.addAttribute("recipe", recipeId);
		return "recipe";
	}
}
