package com.workout.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.workout.resources.Category;
import com.workout.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST, consumes = { "application/json" })
	@CrossOrigin
	public void addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
	}

	@RequestMapping(value = "/listCategories", method = RequestMethod.GET)
	@CrossOrigin
	public List<Category> addCategory() {
		return categoryService.categoryList();
	}
	
	@RequestMapping(value="/deleteCategory", method= RequestMethod.DELETE, consumes = {"application/json"})
	@CrossOrigin
	public void deleteCategory(@RequestBody String categoryId) {
		Gson gson = new Gson();
		Category category = gson.fromJson(categoryId, Category.class);
		categoryService.deleteCategory(category.getId());
	}

}
