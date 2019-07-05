package com.st.studentProject.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.st.studentProject.Model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> 
{
	public List<Student> findAll();
	public Student findStudentById(Long id);
	public List<Student> findAllByFirstNameContainsIgnoreCase(String firstName);
	//public void deleteById(Long id); Already made for the crudrepository
}
