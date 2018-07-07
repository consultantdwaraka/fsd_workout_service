package com.workout.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.junit4.SpringRunner;

import com.workout.repo.WorkoutRepository;
import com.workout.resources.TrackWorkouts;
import com.workout.resources.Workout;

@RunWith(SpringRunner.class)
public class WorkoutServiceTest {
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	private WorkoutRepository workoutRepository;

	@InjectMocks
	public WorkoutServiceImpl workoutService;

	@Test
	public void saveWorkout() {
		Workout workout = new Workout();
		workout.setTitle("Tennies");
		when(this.workoutRepository.save(workout)).thenReturn(workout);
		Workout workoutRes = workoutService.saveWorkout(workout);
		assertEquals(workout.getTitle(), workoutRes.getTitle());
	}

	@Test
	public void findWorkout() {
		Workout workout = new Workout();
		workout.setTitle("Tennies");
		List<Workout> workoutList = new ArrayList<>();
		workoutList.add(workout);
		when(this.workoutRepository.findAll()).thenReturn(workoutList);
		List<Workout> workoutRes = workoutService.findWorkout();
		assertEquals(workoutList.size(), workoutRes.size());
	}

	@Test
	public void deleteWorkout() {
		Workout workout = new Workout();
		workout.setTitle("Tennies");
		this.workoutService.deleteWorkout("");
	}

	@Test
	public void trackWorkouts() {
		Workout workout = new Workout();
		workout.setTitle("Tennies");
		workout.setCalories("100");
		workout.setStartDate(LocalDate.now().toString());
		workout.setStartTime(LocalTime.now().toString());

		workout.setEndDate(LocalDate.now().toString());
		workout.setEndTime(LocalTime.now().plusMinutes(100).toString());

		List<Workout> workoutList = new ArrayList<>();
		workoutList.add(workout);

		workout = new Workout();
		workout.setTitle("Tennies");
		workout.setCalories("100");
		workout.setStartDate(LocalDate.now().minusDays(3).toString());
		workout.setStartTime(LocalTime.now().toString());

		workout.setEndDate(LocalDate.now().minusDays(3).toString());
		workout.setEndTime(LocalTime.now().plusMinutes(20).toString());

		workoutList.add(workout);

		workout = new Workout();
		workout.setTitle("Tennies");
		workout.setCalories("100");
		workout.setStartDate(LocalDate.now().minusDays(2).toString());
		workout.setStartTime(LocalTime.now().toString());

		workout.setEndDate(LocalDate.now().minusDays(2).toString());
		workout.setEndTime(LocalTime.now().plusMinutes(20).toString());

		workoutList.add(workout);

		workout = new Workout();
		workout.setTitle("Tennies");
		workout.setCalories("100");
		workout.setStartDate(LocalDate.now().minusDays(1).toString());
		workout.setStartTime(LocalTime.now().toString());

		workout.setEndDate(LocalDate.now().minusDays(1).toString());
		workout.setEndTime(LocalTime.now().plusMinutes(20).toString());

		workoutList.add(workout);

		workout = new Workout();
		workout.setTitle("Tennies");
		workout.setCalories("100");
		workout.setStartDate(LocalDate.now().minusDays(30).toString());
		workout.setStartTime(LocalTime.now().toString());

		workout.setEndDate(LocalDate.now().minusDays(30).toString());
		workout.setEndTime(LocalTime.now().plusMinutes(20).toString());

		workoutList.add(workout);

		workout = new Workout();
		workout.setTitle("Tennies");
		workout.setCalories("100");
		workout.setStartDate(LocalDate.now().minusDays(40).toString());
		workout.setStartTime(LocalTime.now().toString());

		workout.setEndDate(LocalDate.now().minusDays(40).toString());
		workout.setEndTime(LocalTime.now().plusMinutes(20).toString());

		workoutList.add(workout);

		workout = new Workout();
		workout.setTitle("Tennies");
		workout.setCalories("100");
		workout.setStartDate(LocalDate.now().minusDays(50).toString());
		workout.setStartTime(LocalTime.now().toString());

		workout.setEndDate(LocalDate.now().minusDays(50).toString());
		workout.setEndTime(LocalTime.now().plusMinutes(20).toString());

		workoutList.add(workout);

		workout = new Workout();
		workout.setTitle("Tennies");
		workout.setCalories("100");
		workout.setStartDate(LocalDate.now().minusDays(80).toString());
		workout.setStartTime(LocalTime.now().toString());

		workout.setEndDate(LocalDate.now().minusDays(80).toString());
		workout.setEndTime(LocalTime.now().plusMinutes(20).toString());

		workoutList.add(workout);

		when(this.workoutRepository.findAll()).thenReturn(workoutList);
		TrackWorkouts workoutRes = workoutService.trackWorkouts();
		assertTrue(workoutRes.getDailyWorkouts().size() > 0);
		assertTrue(workoutRes.getMonthlyWorkouts().size() > 0);
		System.out.println("==== Weekly Workouts======");
		workoutRes.getDailyWorkouts().forEach(element -> System.out.println(element));
		System.out.println("==== Monthly Workouts======");
		workoutRes.getWeeklyWorkouts().forEach(element -> System.out.println(element));

		System.out.println("==== Yearly Workouts======");
		workoutRes.getMonthlyWorkouts().forEach(element -> System.out.println(element));

	}

}
