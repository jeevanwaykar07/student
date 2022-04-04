package com.assignment.project;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.assignment.project.entity.StudentEntity;
import com.assignment.project.repository.StudentRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentServiceImplTest {
	
	@Mock
	StudentRepository studentRepository;
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
		
		when(studentRepository.save(student)).thenReturn(student);
	}
	
	
	}

}
