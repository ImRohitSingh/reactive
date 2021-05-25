package com.test.reactive.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Document(collection = "employee")
@Data
public class Employee {

	@Id
	@JsonIgnore
	private ObjectId id;

	String name;

	long salary;

}
