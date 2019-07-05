package com.st.recipe;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.recipe.model.Recipe;
import com.st.recipe.repository.RecipeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeRepositoryTest {

	@Autowired
	TestEntityManager testEntityManager;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	private static Recipe applePie;
	private static Recipe raspberryPie;
	
	@Before
	public void setUp()
	{
		raspberryPie = new Recipe("Rasberry Pie", 5, 90);
		testEntityManager.persistAndFlush(raspberryPie);
		
		applePie = new Recipe("Apple Pie", 5, 90);
		testEntityManager.persistAndFlush(applePie);
	}
	@After
	public void teatDown()
	{
		recipeRepository.deleteAll();
	}
	
	@Test
	public void givenFindByName_thenReturnRecipe() 
	{
		Recipe found = recipeRepository.findRecipeByName(raspberryPie.getName());
		assertThat(raspberryPie.getName()).isEqualTo(found.getName());
	}
	
	@Test
	public void whenGivenAllRecipes_thenReturnList()
	{
		List<Recipe> found = recipeRepository.findAll();
		assertThat(1).isEqualTo(found.size());
	}
}
