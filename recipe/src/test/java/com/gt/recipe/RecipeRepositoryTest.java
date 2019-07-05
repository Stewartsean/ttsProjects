package com.gt.recipe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.gt.recipe.model.Recipe;
import com.gt.recipe.repository.RecipeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeRepositoryTest {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void whenGivenName_thenReturnRecipe() {
		Recipe applePie = new Recipe("Apple Pie", 5, 90);
		testEntityManager.persistAndFlush(applePie);

		Recipe found = recipeRepository.findRecipeByName(applePie.getName());
		
		assertThat(applePie).isEqualToComparingFieldByField(found);
	}
	
	@Test
	public void whenGivenAllRecipes_thenReturnList() {
		Recipe raspberryPie = new Recipe("Raspberry Pie", 5, 90);
		testEntityManager.persistAndFlush(raspberryPie);
		
		List<Recipe> found = recipeRepository.findAll();
		assertEquals(1, found.size());		
	}

}
