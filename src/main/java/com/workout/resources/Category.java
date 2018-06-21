package com.workout.resources;

import org.springframework.data.annotation.Id;

public class Category {
	@Id
	private String id;

	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
