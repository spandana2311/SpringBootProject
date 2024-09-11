package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}

	public Student getStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	public Student postStudents(Student student) {
		Student s=studentRepository.save(student);
		return s;
	}

	public String deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
		return "Deleted";
	}

	public String putStudentById(Integer id, Student updatingstudent) {
		
		//get the record from db
		Optional<Student> existingStudent = studentRepository.findById(id);
		if(existingStudent.isPresent()){
			
			//modify in app layer
			Student student=existingStudent.get();
			student.setName(updatingstudent.getName());

			//save the updated record
			studentRepository.save(student);
			return "Update Success";
		}
		else {

			return "record not found";
		}
	}
}
