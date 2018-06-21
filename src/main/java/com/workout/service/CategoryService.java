package com.workout.service;

import java.util.List;

import com.workout.resources.Category;

public interface CategoryService {

	public void addCategory(Category category);

	public List<Category> categoryList();
	
	public void deleteCategory(String id);

}
