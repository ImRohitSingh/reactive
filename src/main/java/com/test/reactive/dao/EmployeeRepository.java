package com.test.reactive.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import com.test.reactive.models.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, ObjectId> {

	@Tailable
	@Query("{ 'id': ?0 }")
	Mono<Employee> findById(final ObjectId id);

	@Tailable
	@Query("{ 'name': ?0 }")
	Flux<Employee> findByName(final String name);

	@Tailable
	@Query("{}")
	Flux<Employee> findAllEmployees();

}
