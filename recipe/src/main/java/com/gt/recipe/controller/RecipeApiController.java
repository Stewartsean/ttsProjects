package com.gt.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gt.recipe.model.Recipe;
import com.gt.recipe.service.RecipeServiceImpl;

@RestController
@RequestMapping("/api")
public class RecipeApiController {
	@Autowired
	RecipeServiceImpl recipeServiceImpl;
	
	@GetMapping("/recipes")
	public List<Recipe> findAllRecipes(){
		return recipeServiceImpl.findAll();
	}
}
