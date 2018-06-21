package com.workout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.repo.WorkoutRepository;
import com.workout.resources.Workout;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;

	@Override
	public void saveWorkout(Workout workout) {
		workoutRepository.save(workout);
	}

	@Override
	public List<Workout> findWorkout() {
		return workoutRepository.findAll();
	}

	@Override
	public void deleteWorkout(String id) {
		workoutRepository.deleteById(id);
	}

}
