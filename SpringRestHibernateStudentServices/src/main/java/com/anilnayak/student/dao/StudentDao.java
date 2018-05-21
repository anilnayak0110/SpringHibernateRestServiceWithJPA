package com.anilnayak.student.dao;

import java.util.List;

import com.anilnayak.student.model.Student;

public interface StudentDao {

	public void createStudent(Student student);

	public Student getStudentById(int id);

	public List<Student> getAllStudent();

	public void updateStudent(Student student);

	public void deleteStudentById(int id);
}
