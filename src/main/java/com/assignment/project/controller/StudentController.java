package com.assignment.project.controller;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.project.entity.StudentEntity;
import com.assignment.project.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public StudentEntity saveOrder(@RequestBody StudentEntity student) {
		
		return this.studentService.addStudent(student);
		
	}
	
	@PutMapping("/update/{studentId}")
	public void updatestudent(@RequestBody StudentEntity studentEntity, @PathVariable("studentId") long studentId) {
		
		 this.studentService.Update(studentEntity, studentId);
		
	}
	
	@GetMapping("/student/{Id}")
	public StudentEntity getOneUser(@RequestParam Long id) {
		
		Consumer<Integer> con = t-> studentService.getStudentInfo(id);
		return (StudentEntity) con;
	}
	@GetMapping("/student")
	public List<StudentEntity> getAllRecordsdb(StudentEntity student) {
		List<StudentEntity> studentList = studentService.getAllStudent();
		return studentList;
	}
	
	@DeleteMapping("/student/{studentId}")
	public void deleteStudent( @PathVariable("studentId") long studentId) {
		
		 this.studentService.deleteStudnet(studentId);
		
	}
	
}
