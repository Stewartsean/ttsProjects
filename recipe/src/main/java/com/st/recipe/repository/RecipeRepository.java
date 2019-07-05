package com.st.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.recipe.model.Recipe;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>
{
	public Recipe findRecipeByName(String name);
	public Recipe findRecipeById(Long id);
}
