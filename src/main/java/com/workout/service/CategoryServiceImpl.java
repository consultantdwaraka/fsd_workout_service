package com.workout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.repo.CategoryRepository;
import com.workout.resources.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public List<Category> categoryList() {
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategory(String id) {
		categoryRepository.deleteById(id);
	}

}
