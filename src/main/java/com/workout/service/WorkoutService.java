package com.workout.service;

import java.util.List;

import com.workout.resources.Workout;

public interface WorkoutService {

	public void saveWorkout(Workout workout);

	public List<Workout> findWorkout();
	
	public Workout findWorkoutById(String id);

	public void deleteWorkout(String id);

}
