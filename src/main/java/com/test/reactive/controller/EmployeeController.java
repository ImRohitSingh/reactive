package com.test.reactive.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.reactive.models.Employee;
import com.test.reactive.services.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PutMapping(path = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Employee e) {
		e.setId(ObjectId.get());
		employeeService.create(e);
	}

	@GetMapping(path = "/getById/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") ObjectId id) {
		Mono<Employee> e = employeeService.findById(id);
		HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(e, status);
	}

	@GetMapping(path = "/getByName/{name}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employee> findByName(@PathVariable("name") String name) {
		return employeeService.findByName(name);
	}

	@GetMapping(path = "/getAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employee> findAll() {
		return employeeService.findAll();
	}

}
