package com.assignment.project.serviceImpl;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.project.entity.StudentEntity;
import com.assignment.project.repository.StudentRepository;
import com.assignment.project.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;
	static Predicate<StudentEntity> predicateByGpa = (stu) -> Double.parseDouble(stu.getGpa())>=3.5;
	
	

	@Override
	public StudentEntity addStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Object getStudentInfo(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.getOne(id);
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll().stream().filter(predicateByGpa).collect(Collectors.toList());
	}

	@Override
	public void Update(StudentEntity studentEntity, long studentId) {
	
		List<StudentEntity> list = studentRepository.findAll();
		list.stream().map(s ->{
			if(s.getId()==studentId) {
				s.setGender(studentEntity.getGender());
			}
			return studentRepository.save(s);
		}).collect(Collectors.toList());
		
	}

	@Override
	public void deleteStudnet(long studentId) {
		studentRepository.deleteById(studentId);
		
	}

}
