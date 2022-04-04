package com.assignment.project;

import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.assignment.project.entity.StudentEntity;
import com.assignment.project.service.StudentService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
	
	@Mock
	StudentService studentService;
	
	@Test
	public void save() {
		
		StudentEntity student = new StudentEntity();
		
		student.setGender("Male");
		student.setGpa("3.5");
		student.setGradeLevel("7.5");
		student.setId(1);
		student.setName("Jeevan");
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(studentService.addStudent(student)).thenReturn(student);
	}
	
	@Test
	public void updatestudent() {
		
		StudentEntity student = new StudentEntity();
		
		student.setGender("Male");
		student.setGpa("3.5");
		student.setGradeLevel("7.5");
		student.setId(1);
		student.setName("Jeevan");
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(studentService.Update(student, 0)).thenReturn(student);
		assertThat(student.getId()).isEqualTo(1);
	}
	
}
