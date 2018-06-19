package com.workout.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public List<String> addCategory() {
		return categoryService.categoryList().stream().map(element -> element.getCategory())
				.collect(Collectors.toList());
	}

}
