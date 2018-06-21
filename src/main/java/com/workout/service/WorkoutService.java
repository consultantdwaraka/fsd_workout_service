package com.workout.service;

import java.util.List;

import com.workout.resources.Workout;

public interface WorkoutService {

	public void saveWorkout(Workout workout);

	public List<Workout> findWorkout();

	public void deleteWorkout(String id);

}
