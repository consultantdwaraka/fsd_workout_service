/**
 * 
 */
package com.workout.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workout.resources.Workout;

/**
 * @author dwaraka
 *
 */
public interface WorkoutRepository extends MongoRepository<Workout, String> {

}
