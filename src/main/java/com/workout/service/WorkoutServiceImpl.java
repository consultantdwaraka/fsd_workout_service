package com.workout.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.workout.repo.WorkoutRepository;
import com.workout.resources.TrackWorkouts;
import com.workout.resources.Workout;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	private static final String WEEK5 = "Week5";
	private static final String WEEK4 = "Week4";
	private static final String WEEK3 = "Week3";
	private static final String WEEK2 = "Week2";
	private static final String WEEK1 = "Week1";

	static Logger logger = LoggerFactory.getLogger(WorkoutServiceImpl.class);

	@Autowired
	private WorkoutRepository workoutRepository;

	@Override
	public Workout saveWorkout(Workout workout) {
		return workoutRepository.save(workout);
	}

	@Override
	public List<Workout> findWorkout() {
		return workoutRepository.findAll();
	}

	@Override
	public void deleteWorkout(String id) {
		workoutRepository.deleteById(id);
	}

	@Override
	public Workout findWorkoutById(String id) {
		return this.workoutRepository.findById(id).get();
	}

	@Override
	public TrackWorkouts trackWorkouts() {
		logger.info("Fetching workout track details...");
		TrackWorkouts trackWorkout = new TrackWorkouts();

		List<Workout> workoutList = workoutRepository.findAll();
		Collection<Long> weeklyWorkouts = this.getWeeklyWorkouts(workoutList);
		trackWorkout.setDailyWorkouts(weeklyWorkouts);
		trackWorkout.setWeeklyWorkouts(this.getMonthlyWorkouts(workoutList));
		trackWorkout.setMonthlyWorkouts(this.getYearlyWorkouts(workoutList));
		return trackWorkout;
	}

	private Collection<Long> getYearlyWorkouts(List<Workout> workoutList) {
		Map<Month, Long> weekklyWorkoutsList = new TreeMap<>();
		weekklyWorkoutsList.put(Month.JANUARY, 0l);
		weekklyWorkoutsList.put(Month.FEBRUARY, 0l);
		weekklyWorkoutsList.put(Month.MARCH, 0l);
		weekklyWorkoutsList.put(Month.APRIL, 0l);
		weekklyWorkoutsList.put(Month.MAY, 0l);
		weekklyWorkoutsList.put(Month.JUNE, 0l);
		weekklyWorkoutsList.put(Month.JULY, 0l);
		weekklyWorkoutsList.put(Month.AUGUST, 0l);
		weekklyWorkoutsList.put(Month.SEPTEMBER, 0l);
		weekklyWorkoutsList.put(Month.OCTOBER, 0l);
		weekklyWorkoutsList.put(Month.NOVEMBER, 0l);
		weekklyWorkoutsList.put(Month.DECEMBER, 0l);

		workoutList.forEach(workout -> {
			if (workout.getStartDate() != null && workout.getEndDate() != null) {
				LocalDate startDate = convertStrToDate(workout.getStartDate());
				LocalTime startTime = convertStrToTime(workout.getStartTime());
				LocalTime endTime = convertStrToTime(workout.getEndTime());
				int startTimeInMin = startTime.getHour() * 60 + startTime.getMinute();
				int endTimeInMin = endTime.getHour() * 60 + endTime.getMinute();
				int workoutTime = endTimeInMin - startTimeInMin;

				int caloriesBurntPerMin = StringUtils.isEmpty(workout.getCalories()) ? 1
						: Integer.parseInt(workout.getCalories());

				int totalCaloriesBurnt = caloriesBurntPerMin * workoutTime;

				logger.info("Time:- " + startTime + " Start date: " + startDate.getMonthValue()
						+ "Total Calories Burnt: " + totalCaloriesBurnt);

				Long previousValue = weekklyWorkoutsList.get(startDate.getMonth());
				Long totalValue = previousValue + totalCaloriesBurnt;
				weekklyWorkoutsList.put(startDate.getMonth(), totalValue);

			}
		});

		return weekklyWorkoutsList.values();
	}

	private Collection<Long> getMonthlyWorkouts(List<Workout> workoutList) {
		Map<String, Long> weekklyWorkoutsList = new TreeMap<>();
		weekklyWorkoutsList.put(WEEK1, 0l);
		weekklyWorkoutsList.put(WEEK2, 0l);
		weekklyWorkoutsList.put(WEEK3, 0l);
		weekklyWorkoutsList.put(WEEK4, 0l);
		weekklyWorkoutsList.put(WEEK5, 0l);

		workoutList.forEach(workout -> {
			if (workout.getStartDate() != null && workout.getEndDate() != null) {

				LocalDate startDate = convertStrToDate(workout.getStartDate());
				LocalTime startTime = convertStrToTime(workout.getStartTime());
				LocalTime endTime = convertStrToTime(workout.getEndTime());
				int startTimeInMin = startTime.getHour() * 60 + startTime.getMinute();
				int endTimeInMin = endTime.getHour() * 60 + endTime.getMinute();
				int workoutTime = endTimeInMin - startTimeInMin;

				int caloriesBurntPerMin = StringUtils.isEmpty(workout.getCalories()) ? 1
						: Integer.parseInt(workout.getCalories());

				int totalCaloriesBurnt = caloriesBurntPerMin * workoutTime;

				logger.info("Time:- " + startTime + " Start date: " + startDate.getDayOfMonth()
						+ "Total Calories Burnt: " + totalCaloriesBurnt);
				if (startDate.getDayOfMonth() <= 7) {
					Long previousValue = weekklyWorkoutsList.get(WEEK1);
					Long totalValue = previousValue + totalCaloriesBurnt;
					weekklyWorkoutsList.put(WEEK1, totalValue);
				} else if (startDate.getDayOfMonth() > 7 && startDate.getDayOfMonth() <= 14) {
					Long previousValue = weekklyWorkoutsList.get(WEEK2);
					Long totalValue = previousValue + totalCaloriesBurnt;
					weekklyWorkoutsList.put(WEEK2, totalValue);
				} else if (startDate.getDayOfMonth() > 14 && startDate.getDayOfMonth() <= 21) {
					Long previousValue = weekklyWorkoutsList.get(WEEK3);
					Long totalValue = previousValue + totalCaloriesBurnt;
					weekklyWorkoutsList.put(WEEK3, totalValue);
				} else if (startDate.getDayOfMonth() > 21 && startDate.getDayOfMonth() <= 28) {
					Long previousValue = weekklyWorkoutsList.get(WEEK4);
					Long totalValue = previousValue + totalCaloriesBurnt;
					weekklyWorkoutsList.put(WEEK4, totalValue);
				} else {
					Long previousValue = weekklyWorkoutsList.get(WEEK5);
					Long totalValue = previousValue + totalCaloriesBurnt;
					weekklyWorkoutsList.put(WEEK5, totalValue);
				}
			}
		});

		return weekklyWorkoutsList.values();
	}

	private Collection<Long> getWeeklyWorkouts(List<Workout> workoutList) {
		Map<DayOfWeek, Long> weekklyWorkoutsList = new TreeMap<>();
		weekklyWorkoutsList.put(DayOfWeek.MONDAY, 0l);
		weekklyWorkoutsList.put(DayOfWeek.TUESDAY, 0l);
		weekklyWorkoutsList.put(DayOfWeek.WEDNESDAY, 0l);
		weekklyWorkoutsList.put(DayOfWeek.THURSDAY, 0l);
		weekklyWorkoutsList.put(DayOfWeek.FRIDAY, 0l);
		weekklyWorkoutsList.put(DayOfWeek.SATURDAY, 0l);
		weekklyWorkoutsList.put(DayOfWeek.SUNDAY, 0l);

		LocalDate today = LocalDate.now();

		int startDayOfWeekValue = 7 - today.getDayOfWeek().getValue();
		LocalDate startDayOfWeek = today.minusDays(today.getDayOfWeek().getValue() - 1);
		LocalDate endDayOfWeek = today.plusDays(startDayOfWeekValue);

		List<Workout> workoutLists = workoutList.stream()
				.filter(workout -> (compareDate(convertStrToDate(workout.getStartDate()), startDayOfWeek,
						convertStrToDate(workout.getEndDate()), endDayOfWeek)))
				.collect(Collectors.toList());

		workoutLists.forEach(workout -> {
			LocalDate startDate = convertStrToDate(workout.getStartDate());
			LocalTime startTime = convertStrToTime(workout.getStartTime());
			LocalTime endTime = convertStrToTime(workout.getEndTime());
			int startTimeInMin = startTime.getHour() * 60 + startTime.getMinute();
			int endTimeInMin = endTime.getHour() * 60 + endTime.getMinute();
			int workoutTime = endTimeInMin - startTimeInMin;

			int caloriesBurntPerMin = StringUtils.isEmpty(workout.getCalories()) ? 1
					: Integer.parseInt(workout.getCalories());

			int totalCaloriesBurnt = caloriesBurntPerMin * workoutTime;

			logger.info("Time:- " + startTime + " Start date: " + startDate.getDayOfWeek() + "Total Calories Burnt: "
					+ totalCaloriesBurnt);
			Long previousWorkoutValues = weekklyWorkoutsList.get(startDate.getDayOfWeek()) == null ? 0
					: weekklyWorkoutsList.get(startDate.getDayOfWeek()).longValue();
			Long totalCalories = previousWorkoutValues + totalCaloriesBurnt;

			weekklyWorkoutsList.put(startDate.getDayOfWeek(), totalCalories);
		});

		return weekklyWorkoutsList.values();
	}

	private static LocalDate convertStrToDate(String dateStr) {
		if (dateStr == null) {
			return null;
		}
		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = dt.parse(dateStr);
		} catch (ParseException e) {
			logger.error("convertStrToDate: " + e);
		}
		return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
	}

	private static LocalTime convertStrToTime(String time) {
		if (time == null) {
			return null;
		}

		SimpleDateFormat dt = new SimpleDateFormat("hh:mm");
		Date date = null;
		try {
			date = dt.parse(time);
		} catch (ParseException e) {
			logger.error("convertStrToTime: " + e);
		}

		return LocalTime.parse(new SimpleDateFormat("hh:mm").format(date));
	}

	private static boolean compareDate(LocalDate startDate, LocalDate weekStartlocalDate, LocalDate endDate,
			LocalDate weekEndDate) {

		if (startDate == null || endDate == null) {
			return false;
		}

		return (startDate.isAfter(weekStartlocalDate) || startDate.isEqual(weekStartlocalDate))
				&& (endDate.isBefore(weekEndDate) || endDate.isEqual(weekEndDate));
	}

}
