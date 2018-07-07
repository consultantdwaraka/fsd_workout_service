package com.workout.service;

import java.util.List;

import com.workout.resources.TrackWorkouts;
import com.workout.resources.Workout;

public interface WorkoutService {

	public Workout saveWorkout(Workout workout);

	public List<Workout> findWorkout();
	
	public Workout findWorkoutById(String id);

	public void deleteWorkout(String id);
	
	public TrackWorkouts trackWorkouts();

}
