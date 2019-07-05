package com.st.recipe;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.st.recipe.model.Recipe;
import com.st.recipe.service.RecipeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = RecipeApplication.class)
		
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integration.properties")

public class RecipeIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	
	private Recipe pizza;
	
	@Before
	public void setUp()
	{
		pizza = new Recipe("Peperroni Pizza", 5, 20);
		recipeServiceImpl.saveRecipe(pizza);
	}
	
	@After
	public void tearDown()
	{
		recipeServiceImpl.deleteAll();
	}
//	@Test
//	public void getIndex_getRecipeById_thenStatus200AndHtml()
//	  throws Exception {
//	  
//	    mvc.perform(get("/recipe" + pizza.getId())
//	      .contentType(MediaType.TEXT_HTML))
//	      .andExpect(status().isOk())
//	      .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
	}
	@Test
	public void whenGivenRecipes_getAllrecipes_thenApiWorksAsExpected()
	  throws Exception {
	  
	    mvc.perform(get("/api/recipes")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].name", is(pizza.getName())));
	}
	
	@Test
	public void whenGivenRecipe_getRecipeById_thenStatus200AndHtml()
	  throws Exception {
	  
	    mvc.perform(get("/recipe" + pizza.getId())
	      .contentType(MediaType.TEXT_HTML))
	      .andExpect(status().isOk())
	      .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
	}


 
}
