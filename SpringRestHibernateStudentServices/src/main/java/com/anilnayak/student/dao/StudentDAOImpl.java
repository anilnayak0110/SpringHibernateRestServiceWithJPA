package com.anilnayak.student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilnayak.student.model.Student;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StudentDAOImpl implements StudentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createStudent(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student getStudentById(int id) {
		return entityManager.find(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		return entityManager.createQuery("select std from Student std").getResultList();
	}

	@Override
	public void updateStudent(Student student) {
		entityManager.merge(student);
	}

	@Override
	public void deleteStudentById(int id) {
		Student std = entityManager.find(Student.class, id);
		entityManager.remove(std);
	}

}
