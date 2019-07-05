package com.gt.recipe;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gt.recipe.model.Recipe;
import com.gt.recipe.service.RecipeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(
	webEnvironment = WebEnvironment.MOCK,
	classes = RecipeApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(
	locations = "classpath:application-integrationtest.properties"
)
public class RecipeIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;

	@Test
	public void whenGivenRecipes_thenWorksAsExpected() throws Exception {
		Recipe pizza = new Recipe("Mushroom and Bacon Pizza", 5, 20);
		
		recipeServiceImpl.saveRecipe(pizza);
		
		mvc.perform(get("/api/recipes").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(
				content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(
					jsonPath("$", hasSize(1)))
			.andExpect(
					jsonPath("$[0].name", is(pizza.getName())));
	}

}
