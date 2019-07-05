//package com.st.recipe;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.st.recipe.model.Recipe;
//import com.st.recipe.repository.RecipeRepository;
//import com.st.recipe.service.RecipeServiceImpl;
//import com.st.recipe.service.RecipeServiceInt;
//
//
//@RunWith(SpringRunner.class)
//
//public class RecipeServiceImplTest {
//
//	@TestConfiguration
//	static class ServiceConfiguration
//	{
//		@Autowired 
//		RecipeServiceInt recipeServiceImpl;
//		
//		@Bean
//		public RecipeServiceInt recipeService()
//		{
//			return new RecipeServiceImpl();
//		}
//		
//		
//		@MockBean
//		RecipeRepository recipeRepository;
//		
//		
//		@Before
//		public void setUp()
//		{
//			Recipe paoDeQueijo = new Recipe("PaoDeQueijo", 2, 20);
//			Mockito.when(recipeRepository.findRecipeByName(paoDeQueijo.getName())).thenReturn(paoDeQueijo);
//		}
//		
//		@Test
//		public void test() 
//		{
//			String name = "PaoDeQueijo";
//			Recipe found = recipeServiceImpl.findByName(name);
//			assertEquals(name, found.getName());
//		}
//	}
//	
//
//}
