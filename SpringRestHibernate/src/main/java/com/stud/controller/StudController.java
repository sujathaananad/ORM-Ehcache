package com.stud.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stud.model.Stud;
import com.stud.model.StudManytoMany;
import com.stud.model.University;
import com.stud.service.*;



@RestController
public class StudController {

	@Autowired
	private StudServiceImpl studentServiceImpl;

	/*** Creating a new Student ***/
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void createStudent(@RequestBody Stud student) {
		
		University university=studentServiceImpl.getByUniversity_id(1);
		System.out.println(university.toString());
		student.setUniversity(university);
		studentServiceImpl.createStudent(student);
	}
	
	@RequestMapping(value = "/getunivstud",  produces ="application/json", method = RequestMethod.GET)
	
	public ResponseEntity<List<Stud>> getunivStud() throws IOException {
		
	University university=new University();
	List<Stud> studList =studentServiceImpl.getStudsByUniversity(1);
	university.setStud(studList);
	
	university.getStud().stream().forEach(System.out::println);
	return ResponseEntity.status(HttpStatus.OK).body(studList);
	} 
	
	/*** Retrieve a single Student ***/
 
	@RequestMapping(value = "/student/{id}", produces = "application/json", method = RequestMethod.GET)
	public Stud getStudentById(@PathVariable("id") long id) {
		return studentServiceImpl.getStudentById(id);
	}

	/*** Retrieve all Students ***/
	//"application/json"
	@RequestMapping(value = "/students", produces ="application/json", method = RequestMethod.GET)
	public List<Stud> getAllStudents() {

		return studentServiceImpl.getAllStudents();
	}

	/*** Update a Student ***/
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateStudent(@RequestBody Stud student) {

		studentServiceImpl.updateStudent(student);
	}

	/*** Delete a Student ***/
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteStudent(@PathVariable("id") long id) {
		studentServiceImpl.deleteStudent(id);
	}
	
	
	@RequestMapping(value="/manyTomany",method=RequestMethod.POST)
	public void saveStudManyDetails(@RequestBody StudManytoMany stud) {
		studentServiceImpl.saveStudManyDetails(stud);
	}
}
