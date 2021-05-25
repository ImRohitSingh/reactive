package com.test.reactive.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.reactive.dao.EmployeeRepository;
import com.test.reactive.models.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void create(Employee e) {
		employeeRepository.save(e).subscribe();
	}

	@Override
	public Mono<Employee> findById(ObjectId id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Flux<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public Flux<Employee> findAll() {
		return employeeRepository.findAllEmployees();
	}

}
