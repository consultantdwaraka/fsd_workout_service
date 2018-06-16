package com.workout.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.resources.Workout;

@RestController
public class WorkoutController {
	private List<Workout> workoutList = new ArrayList<>();

	@RequestMapping(value = "/workouts", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin
	public HttpEntity<List<Workout>> getWorkoutList() {

		Workout workout = new Workout();
		workout.setWorkoutId(1);
		workout.setTitle("Running");
		workout.setCategory("category one");
		workout.setDescription("no description");
		workout.setCalariesBurntPerMin(100);
		workoutList.add(workout);

		workout = new Workout();
		workout.setWorkoutId(2);
		workout.setTitle("Jogging");
		workout.setCategory("category one");
		workout.setDescription("no description");
		workout.setCalariesBurntPerMin(200);
		workoutList.add(workout);

		workout = new Workout();
		workout.setWorkoutId(3);
		workout.setTitle("Tennies playing");
		workout.setCategory("category one");
		workout.setDescription("no description");
		workout.setCalariesBurntPerMin(200);
		workoutList.add(workout);

		return new ResponseEntity<>(workoutList, HttpStatus.OK);
	}

}
