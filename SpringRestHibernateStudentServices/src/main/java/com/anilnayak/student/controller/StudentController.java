package com.anilnayak.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anilnayak.student.dao.StudentDAOImpl;
import com.anilnayak.student.model.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentDAOImpl studentImpl;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void createStudent(@RequestBody Student student) {
		studentImpl.createStudent(student);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = "application/json")
	public Student getStudentById(@PathVariable("id") int id) {
		return studentImpl.getStudentById(id);

	}

	@RequestMapping(value = "/allstudents", method = RequestMethod.GET, produces = "application/json")
	public List<Student> getAllStudent() {
		return studentImpl.getAllStudent();

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateStudent(@RequestBody Student student) {
		studentImpl.updateStudent(student);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteStudent(@PathVariable("id") int id) {
		studentImpl.deleteStudentById(id);
	}

}
