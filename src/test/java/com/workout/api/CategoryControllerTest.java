package com.workout.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.workout.resources.Category;
import com.workout.service.CategoryServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryControllerTest.class)
public class CategoryControllerTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	private CategoryServiceImpl categoryService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void addCategory() {
		Category category = new Category();
		category.setId("123");
		category.setCategory("Test Category");
		Gson gson = new Gson();
		String json = gson.toJson(category);
		when(this.categoryService.addCategory(category)).thenReturn(category);
		try {
			this.mockMvc
					.perform(put("/addCategory").accept(MediaType.APPLICATION_JSON)
							.characterEncoding(StandardCharsets.UTF_8.toString())
							.contentType(MediaType.APPLICATION_JSON).content(json))
					.andExpect(status().isNotFound()).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
