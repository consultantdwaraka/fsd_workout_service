package com.workout.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.junit4.SpringRunner;

import com.workout.repo.CategoryRepository;
import com.workout.resources.Category;

@RunWith(SpringRunner.class)
public class CategoryServiceTest {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryServiceImpl categoryService;

	@Test
	public void addCategory() {
		Category category = new Category();
		category.setCategory("Test");
		when(this.categoryRepository.save(category)).thenReturn(category);
		Category categoryRes = this.categoryService.addCategory(category);
		assertEquals(category.getCategory(), categoryRes.getCategory());

	}

	@Test
	public void categoryList() {
		Category category = new Category();
		category.setCategory("Test");
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(category);
		when(this.categoryRepository.findAll()).thenReturn(categoryList);
		List<Category> categoryRes = this.categoryService.categoryList();
		assertEquals(categoryList.size(), categoryRes.size());

	}

	@Test
	public void removeCategory() {
		Category category = new Category();
		category.setCategory("Test");
		this.categoryService.deleteCategory("123");

	}
}
