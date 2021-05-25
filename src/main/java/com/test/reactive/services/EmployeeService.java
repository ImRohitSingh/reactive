package com.test.reactive.services;

import org.bson.types.ObjectId;

import com.test.reactive.models.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

	void create(Employee e);

	Mono<Employee> findById(ObjectId id);

	Flux<Employee> findByName(String name);

	Flux<Employee> findAll();

}
