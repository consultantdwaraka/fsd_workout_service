package com.workout.resources;

public class Workout {

	private Integer workoutId;

	private String title;

	private String description;

	private Integer calariesBurntPerMin;

	private String category;

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId = workoutId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCalariesBurntPerMin() {
		return calariesBurntPerMin;
	}

	public void setCalariesBurntPerMin(Integer calariesBurntPerMin) {
		this.calariesBurntPerMin = calariesBurntPerMin;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
