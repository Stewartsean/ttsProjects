package com.gt.recipe;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gt.recipe.model.Recipe;
import com.gt.recipe.repository.RecipeRepository;
import com.gt.recipe.service.RecipeServiceImpl;
import com.gt.recipe.service.RecipeServiceInt;

@RunWith(SpringRunner.class)
public class RecipeServiceImplTest {
	
	@TestConfiguration
	static class ServiceConfiguration {
		@Bean
		public RecipeServiceInt recipeService()
		{
			return new RecipeServiceImpl();
		}
	}
	@Autowired
	RecipeServiceInt recipeServiceImpl;
	
	@MockBean
	RecipeRepository recipeRepository;
	
	@Before
	public void setUp()
	{
		Recipe paoDeQueijo = new Recipe("Pao De Queijo", 2, 20);
		Mockito.when(recipeRepository.findRecipeByName(paoDeQueijo.getName()))
			.thenReturn(paoDeQueijo);
	}

	@Test
	public void whenGivenName_thenReturnMatchingRecipeName() {
		String name = "Pao De Queijo";
		Recipe found = recipeServiceImpl.findByName(name);
		assertEquals(name, found.getName());
	}
	
	// Create Test for save method

}
