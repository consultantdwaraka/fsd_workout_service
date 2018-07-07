package com.workout.resources;

import java.util.Collection;

public class TrackWorkouts {

	private Collection<Long> dailyWorkouts;

	private Collection<Long> weeklyWorkouts;

	private Collection<Long> monthlyWorkouts;

	public Collection<Long> getDailyWorkouts() {
		return dailyWorkouts;
	}

	public void setDailyWorkouts(Collection<Long> dailyWorkouts) {
		this.dailyWorkouts = dailyWorkouts;
	}

	public Collection<Long> getWeeklyWorkouts() {
		return weeklyWorkouts;
	}

	public void setWeeklyWorkouts(Collection<Long> weeklyWorkouts) {
		this.weeklyWorkouts = weeklyWorkouts;
	}

	public Collection<Long> getMonthlyWorkouts() {
		return monthlyWorkouts;
	}

	public void setMonthlyWorkouts(Collection<Long> monthlyWorkouts) {
		this.monthlyWorkouts = monthlyWorkouts;
	}

}
