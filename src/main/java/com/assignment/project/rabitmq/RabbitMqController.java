package com.assignment.project.rabitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.project.model.StudentDto;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMqController {
	
	@Autowired
	RabbitMqSender rabbitMQSender;

	@PostMapping(value = "/producer")
	public String producer(@RequestBody StudentDto stus) {
		
		rabbitMQSender.send(stus);

		return "Message sent to the RabbitMQ Successfully";
	}

}
