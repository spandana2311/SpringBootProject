package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.serviceimpl.StudentServiceimpl;

@RestController

public class StudentController {

	@Autowired
	StudentServiceimpl studentService;


	@GetMapping(value="/get")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping(value="/getbyId/{id}")
	public Student getStudentById(@PathVariable("id") Integer id) {
		return studentService.getStudentById(id);
	}

	@GetMapping(value="/getbyName/{name}")
	public Student getStudentByName(@PathVariable("name") String name) {
		return studentService.getStudentByName(name);
	}

	//insert a student into DB
	@PostMapping(value="/post")
	public Student postStudents(@RequestBody Student student) {
		return studentService.postStudents(student);
	}

	//delete student by id
	@DeleteMapping(value="/delete/{id}")
	public String deleteStudentById(@PathVariable("id") Integer id) {
		return studentService.deleteStudentById(id);
	}

	//update student by id
	@PutMapping(value="/put/{id}")
	public String putStudentById(@PathVariable("id") Integer id ,@RequestBody Student student) {
		return studentService.putStudentById(id, student);
	}
}
