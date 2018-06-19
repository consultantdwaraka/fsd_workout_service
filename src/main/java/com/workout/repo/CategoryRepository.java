package com.workout.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workout.resources.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
