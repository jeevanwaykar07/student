package com.assignment.project.service;

import java.util.List;

import com.assignment.project.entity.StudentEntity;

public interface StudentService {

	StudentEntity addStudent(StudentEntity student);

	Object getStudentInfo(Long id);

	List<StudentEntity> getAllStudent();

	void Update(StudentEntity studentEntity, long studentId);

	void deleteStudnet(long studentId);

}
