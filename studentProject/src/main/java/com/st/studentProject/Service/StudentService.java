package com.st.studentProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.studentProject.Model.Student;
import com.st.studentProject.Repository.StudentRepository;

@Service
public class StudentService
{
	@Autowired
	StudentRepository studentRepository;
	
	public Student findStudent(Long id)
	{
		return studentRepository.findStudentById(id);
	}
	
	public List<Student> findAll()
	{
		return studentRepository.findAll();
	}
	public List<Student> findAllFirstName(String firstName)
	{
		return studentRepository.findAllByFirstNameContainsIgnoreCase(firstName);
	}
	public void deleteAll()
	{
		studentRepository.deleteAll();
	}
	public void deleteById(Long id)
	{
		 studentRepository.deleteById(id);
	}
	public void saveStudent(Student student)
	{
		studentRepository.save(student);
	}
	public void updateStudent (Long id, Student studentUpdate)
	{
		Student studentReplace = studentRepository.findStudentById(id);
		String tempFirstName = studentUpdate.getFirstName();
		String tempLastName = studentUpdate.getLastName();
		String tempAdjName = studentUpdate.getAdjName();
		
		if(tempFirstName != null) studentReplace.setFirstName(tempFirstName);
		if(tempLastName != null) studentReplace.setLastName(tempLastName);
		if(tempAdjName != null) studentReplace.setAdjName(tempAdjName);
		studentRepository.save(studentReplace);
	}
}