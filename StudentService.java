package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	public List<Student> getStudents();
	
	public Student getStudentById(Integer id) ;
	
	public Student getStudentByName(String name);
	
	public Student postStudents(Student student);
	
	public String deleteStudentById(Integer id);

}
