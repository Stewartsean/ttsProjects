package com.st.studentProject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.studentProject.Model.Student;
import com.st.studentProject.Service.StudentService;
//Use @RestController to show data, but not a site
@Controller
public class StudentController
{
 
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String index()
	{
		return "student/index";//add the file path
	}
	 
	@GetMapping("/students")
		//   List<Student>
	public String allStudents(Model model)
	{
		List<Student> allStudents = studentService.findAll();
		model.addAttribute("students", allStudents);
//		return studentService.findAll();
		return "student/students";
	}
	
	//A method that gets all the student by their first name
	@GetMapping("/students/{firstName}")
//	@ResponseBody
	public List<Student> firstName(@PathVariable String firstName)
	{
		return studentService.findAllFirstName(firstName);
	}
	
	@GetMapping("/student/{id}")
	public String studentById(@PathVariable Long id, Model model)
	{
		Student student = studentService.findStudent(id);
		model.addAttribute("student", student);
		return "student/student";
	}
	
	//Bad practice because going to the address removes all the data in the data base
//	@GetMapping("/deleteall")
//	public void deleteAll()
//	{
//		studentService.deleteAll();
//	}
	
	@DeleteMapping("/students")
	public void deleteAll()
	{
		studentService.deleteAll();
	}
	
	@DeleteMapping("/student/{id}")
	@ResponseBody
	public String deleteStudentById(@PathVariable Long id)
	{
		studentService.deleteById(id);
		return "<h1>Delete Successful</h1>";
	}
	
	@PostMapping("/student/create")
	@ResponseBody
	public String createStudent(Student student, Model model)
	{
		studentService.saveStudent(student);
		return "<h1>Create Student Succesfull</h1>";
	}
	
	@PutMapping("/student/update/{id}")
	@ResponseBody
	public String updateStudent(@PathVariable Long id, Student student)
	{
		studentService.updateStudent(id, student);
		return "<h1>Update Student Successful</h1>";
	}
}