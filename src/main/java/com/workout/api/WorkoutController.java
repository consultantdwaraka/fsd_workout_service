package com.workout.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.workout.resources.TrackWorkouts;
import com.workout.resources.Workout;
import com.workout.service.WorkoutService;

@RestController
public class WorkoutController {

	@Autowired
	private WorkoutService workoutService;

	@RequestMapping(value = "/workouts", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin
	public HttpEntity<List<Workout>> getWorkoutList() {

		List<Workout> workoutList = workoutService.findWorkout();

		return new ResponseEntity<>(workoutList, HttpStatus.OK);
	}

	@RequestMapping(value = "/getWorkout", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin
	public HttpEntity<Workout> getWorkout(@RequestParam String id) {

		Workout workout = workoutService.findWorkoutById(id);

		return new ResponseEntity<>(workout, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/addWorkout", method = RequestMethod.POST, consumes = "application/json")
	public void addWorkout(@RequestBody Workout workout) {
		workoutService.saveWorkout(workout);

	}

	@CrossOrigin
	@RequestMapping(value = "/startWorkout", method = RequestMethod.POST, consumes = "application/json")
	public void startWorkout(@RequestBody Workout workout) {
		workoutService.saveWorkout(workout);
	}

	@CrossOrigin
	@RequestMapping(value = "/endWorkout", method = RequestMethod.POST, consumes = "application/json")
	public void endWorkout(@RequestBody Workout workout) {
		workoutService.saveWorkout(workout);
	}

	@CrossOrigin
	@RequestMapping(value = "/deleteWorkout", method = RequestMethod.DELETE, consumes = "application/json")
	public void deleteCategory(@RequestBody String workout) {
		Gson gson = new Gson();
		Workout workoutRef = gson.fromJson(workout, Workout.class);
		workoutService.deleteWorkout(workoutRef.getId());

	}

	@RequestMapping(value = "/trackWorkout", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin
	public HttpEntity<TrackWorkouts> trackWorkout() {

		TrackWorkouts workout = workoutService.trackWorkouts();

		return new ResponseEntity<>(workout, HttpStatus.OK);
	}

}
